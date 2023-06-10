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
    private RentalDAO rentalDAO = RentalDAO.getInstance();
    private BicycleDAO bicycleDAO = BicycleDAO.getInstance();
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

        Bicycle bicycle_id = bicycleDAO.findByKey(Long.valueOf(req.getParameter("id")));

        // rental 객체 생성
        Rental rental = Rental.builder()
                .startTime(startTime)
                .bicycle(bicycle_id)
                .build();
        rentalDAO.create(rental);

        String alertMessage = (rentalDAO.create(rental) != null) ? "자전거 대여 완료" : "자전거 대여 불가능";
        String redirectPath = "/gijangBicycleRental/rental/rental.do";

        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessage, redirectPath);
        res.getWriter().flush();
    }
}
