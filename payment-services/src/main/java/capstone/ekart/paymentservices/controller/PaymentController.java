package capstone.ekart.paymentservices.controller;

import capstone.ekart.paymentservices.entity.Payment;
import capstone.ekart.paymentservices.model.Cart;
import capstone.ekart.paymentservices.model.CartPaymentResponse;
import capstone.ekart.paymentservices.repository.PaymentRepository;
import capstone.ekart.paymentservices.services.PaymentService;
import capstone.ekart.paymentservices.services.ValidatorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ValidatorService validatorService;

    @GetMapping("/id/{paymentId}")
    public ResponseEntity<Object> getPaymentById(@PathVariable Integer paymentId){
        List<Payment> paymentList = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    /*@PostMapping("/pay-cart/new")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.OK);
    }*/


    @PostMapping("/pay-cart/new")
    public ResponseEntity<?> createPayment(@Valid @RequestBody Payment payment, BindingResult bindingResult){

        Map<String, String> errorMap = validatorService.paymentValidation(bindingResult);
        if(errorMap.isEmpty())
            return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.CREATED);
        else {
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/payment-details/id/{paymentId}")
    @HystrixCommand(fallbackMethod = "handleCartDowntime")
    public ResponseEntity<CartPaymentResponse> getCartPaymentDetails(@PathVariable Integer paymentId){

        CartPaymentResponse cartPaymentResponse = new CartPaymentResponse();
        Payment payment = paymentRepository.findById(paymentId).get();
        cartPaymentResponse.setPayment(payment);

       // List<Cart> paymentList = restTemplate.getForObject("http://localhost:9002/my-cart/all-carts/cart-id/" + paymentId , List.class);
        List<Cart> paymentList = restTemplate.getForObject("http://CART-SERVICE/my-cart/all-carts/cart-id/" + paymentId , List.class);
        cartPaymentResponse.setCartList(paymentList);

        return new ResponseEntity<>(cartPaymentResponse, HttpStatus.OK);
    }

    //calling this method when 'getCartPaymentDetails' & 'Cart-Services' is down!
    public ResponseEntity<CartPaymentResponse> handleCartDowntime (@PathVariable Integer paymentId){


        CartPaymentResponse cartPaymentResponse = new CartPaymentResponse();
        Payment payment = paymentRepository.findById(paymentId).get();
        cartPaymentResponse.setPayment(payment);

        return new ResponseEntity<>(cartPaymentResponse, HttpStatus.OK);

    }




}
