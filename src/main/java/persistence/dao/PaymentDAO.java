package persistence.dao;

import persistence.entity.Payment;

public class PaymentDAO extends DAO<Payment, Long>{
    public PaymentDAO() {
        super(Payment.class);
    }
}
