package controller.history;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.BicycleDAO;
import persistence.dao.RentalDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BicycleStatisticsController implements Controller {
    private final BicycleDAO bicycleDAO = BicycleDAO.getInstance();
    private final RentalDAO rentalDAO = RentalDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("bicycles", bicycleDAO.findAll());
        req.setAttribute("rentals", rentalDAO.findAll());

        HttpUtil.forward(req, res, "/WEB-INF/view/history/bicycleStatistics.jsp");
    }
}