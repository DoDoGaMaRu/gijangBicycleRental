package persistence.dao;

import persistence.entity.Payment;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class PaymentDAO extends DAO<Payment, Long>{
    private static PaymentDAO paymentDAO;

    public static PaymentDAO getInstance(){
        if (paymentDAO == null) {
            paymentDAO = new PaymentDAO();
        }
        return paymentDAO;
    }

    public List<Payment> findAllByDateRangeSerial(java.util.Date startDate, java.util.Date endDate, Object userSerial) {
        return (List<Payment>) execQuery(em -> {
            Query query = em.createQuery("SELECT p FROM " + Payment.class.getSimpleName() + " p WHERE :startDate <= p.regdate AND p.regdate <= :endDate AND :userSerial = p.user.serial", Payment.class);
            LocalDateTime startLocalDateTime = startDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            LocalDateTime endLocalDateTime = endDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            query.setParameter("startDate", startLocalDateTime);
            query.setParameter("endDate", endLocalDateTime);
            query.setParameter("userSerial", userSerial);

            return query.getResultList();
        });
    }

    private PaymentDAO() {
        super(Payment.class);
    }
}
