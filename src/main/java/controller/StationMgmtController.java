package controller;

import persistence.dao.StationDAO;
import persistence.entity.Station;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class StationMgmtController implements Controller{
    private StationDAO stationDAO;

    public StationMgmtController() {
        this.stationDAO = StationDAO.getInstance();
    }

    @Override
    public void execute(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationMgmt.jsp");
        }
        else {
            switch (path[1]) {
                case "regist":
                    registHandling(Arrays.copyOfRange(path, 1, path.length), req, res);
                    break;

            }
        }
    }

    private void registHandling(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationRegist.jsp");
        }
        else {
            switch (path[1]) {
                case "registOK":
                    registOK(req, res);
                    break;
            }
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Station station = Station.builder()
                .name(req.getParameter("name"))
                .coordinate(req.getParameter("coordinate"))
                .address(req.getParameter("address"))
                .build();
        stationDAO.create(station);

        HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationMgmt.jsp");
    }
}
