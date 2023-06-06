package persistence.dao;

import persistence.entity.Payment;

public class PaymentDAO extends DAO<Payment, Long>{
    private static PaymentDAO paymentDAO;

    public static PaymentDAO getInstance(){
        if (paymentDAO == null) {
            paymentDAO = new PaymentDAO();
        }
        return paymentDAO;
    }

    private PaymentDAO() {
        super(Payment.class);
    }
}
