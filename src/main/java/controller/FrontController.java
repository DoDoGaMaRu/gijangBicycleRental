package controller;

import java.io.IOException;
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
        list.put("/operation.do", new OperationController());
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