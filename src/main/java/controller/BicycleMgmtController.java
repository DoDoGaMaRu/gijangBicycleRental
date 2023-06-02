package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BicycleMgmtController implements Controller {

    @Override
    public void execute(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 1) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/bicycle/bicycleMgmt.jsp");
        }

    }
}
