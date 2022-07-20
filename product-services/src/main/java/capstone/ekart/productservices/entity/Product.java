package capstone.ekart.productservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
