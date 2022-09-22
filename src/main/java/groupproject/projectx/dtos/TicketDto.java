package groupproject.projectx.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TicketDto {

    private Integer ticketId;

    private BigDecimal fare;

    private FlightDto flightTicketId;

    private boolean reserved;

    public TicketDto() {
    }
}
