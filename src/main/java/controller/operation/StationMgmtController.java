package controller.operation;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.StationDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StationMgmtController implements Controller {
    private final StationDAO stationDAO = StationDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final int PAGE_SIZE = 10;
        int page;

        String tempPage = req.getParameter("page");
        try {
            page = (tempPage!=null) ? Integer.parseInt(tempPage) : 1;
        }
        catch (NumberFormatException e) {
            page = 1;
        }

        int firstIdx = (page - 1) * PAGE_SIZE;
        req.setAttribute("stations", stationDAO.findAll(firstIdx, PAGE_SIZE));
        req.setAttribute("curPage", page);
        req.setAttribute("endPage", (int) ((stationDAO.count()-1)/PAGE_SIZE + 1));

        HttpUtil.forward(req, res, "/WEB-INF/view/operation/station/stationMgmt.jsp");
    }
}
