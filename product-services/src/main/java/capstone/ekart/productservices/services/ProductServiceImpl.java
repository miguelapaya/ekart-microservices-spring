package capstone.ekart.productservices.services;

import capstone.ekart.productservices.entity.Product;
import capstone.ekart.productservices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductById(Integer productId){
        return productRepository.findProductById(productId);
    }

    @Override
    public List<Product> getOrderById(Integer orderId) {
        return productRepository.findOrderById(orderId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
