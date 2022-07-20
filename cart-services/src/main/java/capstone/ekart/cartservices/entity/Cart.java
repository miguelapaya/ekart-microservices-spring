package capstone.ekart.cartservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    @Column
    private String cartName;

}
