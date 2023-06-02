package controller;

import persistence.dao.StationDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class OperationController implements Controller {
    private HashMap<String, Controller> list = null;

    public OperationController() {
        list = new HashMap<String, Controller>();
        list.put("bicycle", new BicycleMgmtController());
        list.put("station", new StationMgmtController());
    }

    @Override
    public void execute(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/operation/operation.jsp");
        }
        else {
            Controller subController = list.get(path[1]);
            subController.execute(Arrays.copyOfRange(path, 1, path.length), req, res);
        }
    }
}
