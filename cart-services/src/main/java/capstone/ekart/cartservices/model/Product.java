package capstone.ekart.cartservices.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column
    private String productName;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private String brand;
    @Column
    private int price;
    @Column
    private int orderId;
}
