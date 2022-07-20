package capstone.ekart.cartservices.repository;

import capstone.ekart.cartservices.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c WHERE c.cartId = ?1 ")
    List<Cart> findCartById(Integer cartId);

}
