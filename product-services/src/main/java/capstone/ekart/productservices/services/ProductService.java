package capstone.ekart.productservices.services;

import capstone.ekart.productservices.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductById(Integer productId);
    List<Product> getOrderById(Integer orderId);
    Product saveProduct(Product product);

}
