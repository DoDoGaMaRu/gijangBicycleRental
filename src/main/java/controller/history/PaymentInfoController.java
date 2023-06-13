package controller.history;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.PaymentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentInfoController implements Controller {
    private final PaymentDAO paymentDAO = PaymentDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userSerial = req.getParameter("serial");
        String dateFrom = req.getParameter("from");
        String dateTo = req.getParameter("to");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long serial = null;
        Date fromDate = null;
        Date toDate = null;

        try {
            if (dateFrom != null && !dateFrom.isEmpty()) {
                fromDate = sdf.parse(dateFrom);
            }
            if (dateTo != null && !dateTo.isEmpty()) {
                toDate = sdf.parse(dateTo);
            }
            if (userSerial != null && !userSerial.isEmpty()) {
                serial = Long.valueOf(userSerial);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (fromDate != null && toDate != null && serial != null) {
            req.setAttribute("payments", paymentDAO.findAllByDateRangeSerial(fromDate, toDate, serial));
        } else {
            req.setAttribute("payments", new ArrayList<>());
        }

        HttpUtil.forward(req, res, "/WEB-INF/view/history/paymentInfo.jsp");
    }
}
