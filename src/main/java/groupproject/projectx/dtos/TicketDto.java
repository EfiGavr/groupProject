package groupproject.projectx.dtos;

import groupproject.projectx.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TicketDto {

    private Integer ticketId;

    private BigDecimal fare;

    private FlightDto flightTicketId;

    public TicketDto() {
    }
}
