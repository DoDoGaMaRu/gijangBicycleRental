package controller.rental;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.*;
import persistence.entity.Bicycle;
import persistence.entity.Payment;
import persistence.entity.Rental;
import persistence.entity.User;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class BicycleRentalController implements Controller {
    private PaymentDAO paymentDAO = PaymentDAO.getInstance();
    private RentalDAO rentalDAO = RentalDAO.getInstance();
    private BicycleDAO bicycleDAO = BicycleDAO.getInstance();
    private UserDAO userDAO = UserDAO.getInstance();

    private StationDAO stationDAO = StationDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/rental/bicycleRental.jsp");
        }
        else if (req.getMethod().equals("POST")) {
            rentalOK(req, res);
        }
    }

    private void rentalOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // startTime 현재시각으로 설정
        String errInfo = "";

        Long bicycle_id = Long.valueOf(req.getParameter("bicycle_id"));
        String user_id = req.getParameter("user_id");
        Rental rental = null;

        Bicycle bicycle = bicycleDAO.findByKey(bicycle_id);
        User user = userDAO.findBy("id", user_id);

        if (bicycle == null || user == null) {
            errInfo = "사용자 ID 또는 자전거 번호가 존재하지 않습니다.";
        }
        else if (rentalDAO.findCurrentRental(user) != null) {
            errInfo = "이미 자전거를 대여중 입니다.";
        }
        else if (bicycle.getStation() == null) {
            errInfo = "이미 대여 중인 자전거 입니다.";
        }
        else {
            rental = rentalTransaction(bicycle, user);
        }

        String alertMessage = (rental != null) ? "자전거 대여 성공" : "자전거 대여 실패: \\n" + errInfo;
        String redirectPath = "/gijangBicycleRental/main.do";

        res.setContentType("text/html; charset=utf-8;");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessage, redirectPath);
        res.getWriter().flush();
    }

    private Rental rentalTransaction(Bicycle bicycle, User user) {
        Rental rental = null;
        // rental 객체 생성
        rental = Rental.builder()
                .startTime(LocalDateTime.now())
                .bicycle(bicycle)
                .user(user)
                .build();
        rental = rentalDAO.create(rental);

        // payment 객체 생성
        Payment payment = Payment.builder()
                .regdate(LocalDateTime.now())
                .amount(1000)
                .paymentMethod("삼성페이")
                .state("결제완료")
                .user(user)
                .rental(rental)
                .build();
        payment = paymentDAO.create(payment);

        //자전거 상태 업데이트
        bicycle.updateStation(null);
        bicycleDAO.update(bicycle);

        return rental;
    }
}
