package capstone.ekart.cartservices.services;

import capstone.ekart.cartservices.entity.Cart;
import capstone.ekart.cartservices.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServicesImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;


    @Override
    public List<Cart> getCartById(Integer cartId) {
        return cartRepository.findCartById(cartId);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
