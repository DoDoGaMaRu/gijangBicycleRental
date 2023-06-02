package controller;

import persistence.dao.*;
import persistence.entity.Payment;
import persistence.entity.Qna;

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
        list.put("main", new MainController());
        list.put("history", new HistoryController());
        list.put("notice", new NoticeController());
        list.put("operation", new OperationController());
        list.put("rental", new RentalController());
        list.put("user", new UserController());
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String[] path = url.substring(contextPath.length()).replace(".do", "").split("/");

        Controller subController = list.get(path[1]);
        subController.execute(Arrays.copyOfRange(path, 1, path.length), req, res);
    }


}