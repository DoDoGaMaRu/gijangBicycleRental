package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController implements Controller{
    @Override
    public void execute(String[] path, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (path.length < 2) {
            HttpUtil.forward(req, res, "/WEB-INF/view/user/user.jsp");
        }
        else {
            switch (path[1]) {

            }
        }
    }
}
