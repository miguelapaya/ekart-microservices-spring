package capstone.ekart.paymentservices.repository;

import capstone.ekart.paymentservices.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p WHERE p.paymentId =?1 ")
    List<Payment> findPaymentById(Integer paymentId);

}
