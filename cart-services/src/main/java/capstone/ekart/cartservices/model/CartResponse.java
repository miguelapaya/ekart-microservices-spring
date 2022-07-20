package capstone.ekart.cartservices.model;

import capstone.ekart.cartservices.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private Cart cart;
    private List<Product> productList;
}
