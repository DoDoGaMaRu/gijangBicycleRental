package controller.rental;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.PaymentDAO;
import persistence.dao.RentalDAO;
import persistence.dao.UserDAO;
import persistence.entity.Payment;
import persistence.entity.Rental;
import persistence.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RentalStateController implements Controller {
    private RentalDAO rentalDAO = RentalDAO.getInstance();
    private UserDAO userDAO = UserDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long serial = null;
        String serialParam = req.getParameter("serial");

        if (serialParam != null ) {
            serial = Long.valueOf(serialParam);
        }

        User user = userDAO.findByKey(serial);
        Rental rental = rentalDAO.findCurrentRental(user);

        if (rental != null) {
            req.setAttribute("rental", rental);
        }

        HttpUtil.forward(req, res, "/WEB-INF/view/rental/rentalState.jsp");
    }

}
