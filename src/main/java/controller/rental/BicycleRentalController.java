package controller.rental;

import controller.Controller;
import controller.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BicycleRentalController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpUtil.forward(req, res, "/WEB-INF/view/rental/bicycleRental.jsp");
    }
}
