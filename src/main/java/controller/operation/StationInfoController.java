package controller.operation;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.StationDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StationInfoController implements Controller {
    StationDAO stationDAO = StationDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("station", stationDAO.findByKey(id));
        HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationInfo.jsp");
    }
}
