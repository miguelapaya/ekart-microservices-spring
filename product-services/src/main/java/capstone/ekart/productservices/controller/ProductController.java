package capstone.ekart.productservices.controller;

import capstone.ekart.productservices.entity.Product;
import capstone.ekart.productservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/all-products/product-id/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer productId){

        List<Product> productList = productService.getProductById(productId);

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/all-products/order-id/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable Integer orderId){
        List<Product> orderList = productService.getOrderById(orderId);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

}
