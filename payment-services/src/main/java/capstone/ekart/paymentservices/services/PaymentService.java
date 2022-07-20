package capstone.ekart.paymentservices.services;

import capstone.ekart.paymentservices.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentById(Integer paymentId);
    Payment savePayment(Payment payment);
}
