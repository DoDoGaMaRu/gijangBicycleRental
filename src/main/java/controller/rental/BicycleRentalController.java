package controller.rental;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.BicycleDAO;
import persistence.dao.PaymentDAO;
import persistence.dao.RentalDAO;
import persistence.dao.UserDAO;
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
        Long user_serial = Long.valueOf(req.getParameter("user_serial"));

        Bicycle bicycle = bicycleDAO.findByKey(bicycle_id);
        User user = userDAO.findByKey(user_serial);

        // rental 객체 생성
        Rental rental = Rental.builder()
                .startTime(startTime)
                .bicycle(bicycle)
                .build();
        rental = rentalDAO.create(rental);

        Payment payment = Payment.builder()
                .regdate(LocalDateTime.now())
                .amount(1000)
                .paymentMethod("삼성페이")
                .state("결제완료")
                .user(user)
                .rental(rental)
                .build();
        payment = paymentDAO.create(payment);

        String alertMessage = (rental != null) ? "자전거 대여 완료" : "자전거 대여 불가능";
        String redirectPath = "/gijangBicycleRental/rental/rental.do";

        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessage, redirectPath);
        res.getWriter().flush();
    }
}
