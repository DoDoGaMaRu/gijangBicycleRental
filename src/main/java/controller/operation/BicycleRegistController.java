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

public class BicycleRegistController implements Controller {
    private final BicycleDAO bicycleDAO = BicycleDAO.getInstance();
    private final StationDAO stationDAO = StationDAO.getInstance();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/bicycle/bicycleRegist.jsp");
        }
        else if (req.getMethod().equals("POST")) {
            registOK(req, res);
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String stationIdString = req.getParameter("station_id");
        Long stationId = Long.parseLong(stationIdString);
        Station station = stationDAO.findByKey(stationId);

        Bicycle bicycle = Bicycle.builder()
                .state(req.getParameter("state"))
                .station(station)
                .build();

        String alertMessege = (bicycleDAO.create(bicycle) != null) ? "자전거 등록에 성공하였습니다.":"자전거 등록에 실패하였습니다.";
        String redirectPath = "/gijangBicycleRental/operation/bicycleMgmt.do";
        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessege, redirectPath);
        res.getWriter().flush();


        HttpUtil.forward(req, res, "/WEB-INF/view/operation/bicycle/bicycleMgmt.jsp");
    }
}
