package capstone.ekart.cartservices.controller;

import capstone.ekart.cartservices.entity.Cart;
import capstone.ekart.cartservices.model.CartResponse;
import capstone.ekart.cartservices.model.Product;
import capstone.ekart.cartservices.repository.CartRepository;
import capstone.ekart.cartservices.services.CartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/my-cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/all-carts/cart-id/{cartId}")
    public ResponseEntity<Object> getCartById (@PathVariable Integer cartId){
        List<Cart> cartList = cartService.getCartById(cartId);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @PostMapping("/create-cart")
    public ResponseEntity<?> createCart(@RequestBody Cart cart){
        return new ResponseEntity<>(cartService.saveCart(cart), HttpStatus.OK);
    }

    @GetMapping("/cart/{cartId}")
    @HystrixCommand(fallbackMethod = "handleProductDownTime")
    public ResponseEntity<CartResponse> getAllCartById(@PathVariable Integer cartId){
        CartResponse cartResponse = new CartResponse();
        //get cart details
        //List<Cart> cart = cartService.getCartById(cartId);
        Cart cart = cartRepository.findById(cartId).get();
        cartResponse.setCart(cart);


        //get product registered to cart using rest template

        List<Product> productList = restTemplate.getForObject("http://PRODUCT-SERVICE/product/all-products/order-id/" + cartId , List.class);
        cartResponse.setProductList(productList);

        return new ResponseEntity<>(cartResponse, HttpStatus.OK);


    }

    //calling this method when getAllCartById method fails
    public ResponseEntity<CartResponse> handleProductDownTime(@PathVariable Integer cartId){
        CartResponse cartResponse = new CartResponse();
        Cart cart = cartRepository.findById(cartId).get();
        cartResponse.setCart(cart);
        return new ResponseEntity<CartResponse>(cartResponse, HttpStatus.OK);
    }




}
