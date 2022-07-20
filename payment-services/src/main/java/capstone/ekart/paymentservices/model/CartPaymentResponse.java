package capstone.ekart.paymentservices.model;

import capstone.ekart.paymentservices.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPaymentResponse {

    private Payment payment;
    private List<Cart> cartList;
}
