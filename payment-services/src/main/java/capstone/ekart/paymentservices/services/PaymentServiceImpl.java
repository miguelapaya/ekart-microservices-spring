package capstone.ekart.paymentservices.services;

import capstone.ekart.paymentservices.entity.Payment;
import capstone.ekart.paymentservices.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Payment> getPaymentById(Integer paymentId) {
        return paymentRepository.findPaymentById(paymentId);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
