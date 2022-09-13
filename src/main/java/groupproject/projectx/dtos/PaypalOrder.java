package groupproject.projectx.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaypalOrder {

    private double totalAmount;
    private String description;
    private String linkPaypal;

}
