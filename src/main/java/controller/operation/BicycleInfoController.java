package controller.operation;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.BicycleDAO;
import persistence.dao.StationDAO;
import persistence.entity.Bicycle;
import persistence.entity.Station;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BicycleInfoController implements Controller {
    private final BicycleDAO bicycleDAO = BicycleDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        Bicycle bicycle = bicycleDAO.findByKey(id);
        req.setAttribute("bicycle", bicycle);

        HttpUtil.forward(req, res, "/WEB-INF/view/operation/bicycle/bicycleInfo.jsp");
    }

    /*
    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long stationId = Long.parseLong(req.getParameter("stationId"));
        // Station station = stationDAO.findById(stationId); // 기존의 Station을 가져오는 로직

        Bicycle bicycle = Bicycle.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .state(req.getParameter("state"))
                // .station(station)
                .build();
        bicycleDAO.create(bicycle);

        HttpUtil.forward(req, res, "/WEB-INF/view/operation/bicycle/bicycleMgmt.jsp");
    }
    */

}
