package capstone.ekart.paymentservices.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;
    @Column
    @NotBlank(message = "Payment Name can't be empty!")
    private String paymentName;
    @Column
    @NotBlank(message = "Payment Type can't be empty!")
    private String paymentType;
    @Column
    @NotBlank(message = "Card Number can't be empty!")
    @Size(min = 16, max = 19)
    private String cardNumber;
    @Column
    @NotBlank(message = "CVV can't be empty!")
    @Size(min = 3, max = 3)
    private String cvv;
    @Column
    @NotBlank(message = "Card Name can't be empty!")
    private String cardName;
    @Column
    private LocalDate expiryDate;
    @Column
    private int orderId;

}
