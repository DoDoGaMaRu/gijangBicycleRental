package controller;

import controller.history.HistoryController;
import controller.notice.NoticeController;
import controller.notice.NoticeViewController;
import controller.operation.*;
import controller.rental.RentalController;
import controller.user.UserController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String charset = null;
    private HashMap<String, Controller> list = null;

    public FrontController() {
        super();
    }

    @Override
    public void init(ServletConfig sc) throws ServletException {
        charset = sc.getInitParameter("charset");
        list = new HashMap<String, Controller>();
        list.put("/main.do", new MainController());
        list.put("/history.do", new HistoryController());
        list.put("/notice.do", new NoticeController());
        list.put("/notice/view.do", new NoticeViewController());
        list.put("/operation.do", new OperationController());
        list.put("/operation/bicycleMgmt.do", new BicycleMgmtController());
        list.put("/operation/stationMgmt.do", new StationMgmtController());
        list.put("/operation/stationMgmt/regist.do", new StationRegistController());
        list.put("/operation/stationMgmt/info.do", new StationInfoController());
        list.put("/rental.do", new RentalController());
        list.put("/user.do", new UserController());
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        Controller subController = list.get(path);
        subController.execute(req, res);
    }
}