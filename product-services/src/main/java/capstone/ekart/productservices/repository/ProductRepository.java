package capstone.ekart.productservices.repository;

import capstone.ekart.productservices.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productId = ?1 ")
    List<Product> findProductById(Integer productId);

    @Query("SELECT p FROM Product p WHERE p.orderId = ?1 ")
    List<Product> findOrderById(Integer orderId);
}
