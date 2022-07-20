package capstone.ekart.cartservices.services;

import capstone.ekart.cartservices.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCartById(Integer cartId);
    Cart saveCart(Cart cart);

}
