package controller;

import persistence.dao.RentalDAO;
import persistence.entity.Rental;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


public class RentalController implements Controller{

    private RentalDAO rentalDAO;

    public RentalController() {
        this.rentalDAO = RentalDAO.getInstance();
    }

    @Override
    public void execute(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/rental/rental.jsp");
        }
        else {
            switch (path[1]) {

                case "rental":
                    rentalHandling(Arrays.copyOfRange(path, 1, path.length), req, res);
                    break;

                case "state":
                    statusHandling(Arrays.copyOfRange(path, 1, path.length), req, res);
                    break;

            }
        }
    }

    private void rentalHandling(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/rental/bicycleRental.jsp");
        }
        else {
            switch (path[1]) {

                case "rentalOK":
                    rentalOK(req, res);
                    break;

            }
        }
    }

    private void statusHandling(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2)
            HttpUtil.forward(req, res, "/WEB-INF/view/rental/rentalState.jsp");

    }

    private void rentalOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        HttpUtil.forward(req, res, "/WEB-INF/view/rental/bicycleRental.jsp");
    }
}
