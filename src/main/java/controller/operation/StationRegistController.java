package controller.operation;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.StationDAO;
import persistence.entity.Station;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StationRegistController implements Controller {
    private final StationDAO stationDAO = StationDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationRegist.jsp");
        }
        else if (req.getMethod().equals("POST")) {
            registOK(req, res);
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Station station = Station.builder()
                .name(req.getParameter("name"))
                .coordinate(req.getParameter("coordinate"))
                .address(req.getParameter("address"))
                .build();

        String alertMessege = (stationDAO.create(station) != null) ? "대여소 등록에 성공하였습니다.":"대여소 등록에 실패하였습니다.";
        String redirectPath = "/gijangBicycleRental/operation/stationMgmt.do";

        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessege, redirectPath);
        res.getWriter().flush();
    }
}
