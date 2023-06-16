package controller.rental;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.*;
import persistence.entity.Bicycle;
import persistence.entity.Payment;
import persistence.entity.Rental;
import persistence.entity.User;

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
        LocalDateTime startTime = LocalDateTime.now();

        Long bicycle_id = Long.valueOf(req.getParameter("bicycle_id"));
        String user_id = req.getParameter("user_id");
        Rental rental = null;

        Bicycle bicycle = bicycleDAO.findByKey(bicycle_id);
        User user = userDAO.findBy("id", user_id);

        if( bicycle.getStation() != null ) {
            // rental 객체 생성
            rental = Rental.builder()
                    .startTime(startTime)
                    .bicycle(bicycle)
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


            String alertMessage = (rental != null) ? "자전거 대여 성공" : "자전거 대여 실패";
            String redirectPath = "/gijangBicycleRental/rental/rental.do";


            res.setContentType("text/html; charset=utf-8");
            res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessage, redirectPath);
            res.getWriter().flush();

            HttpUtil.forward(req, res, "/WEB-INF/view/rental/bicycleRental.jsp");
        }
    }
}
