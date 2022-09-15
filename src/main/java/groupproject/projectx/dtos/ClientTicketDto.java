package groupproject.projectx.dtos;

import groupproject.projectx.model.Client;
import groupproject.projectx.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class ClientTicketDto {

    private Integer clientTicketId;

    private ClientDto client;

    private TicketDto ticket;

    public ClientTicketDto() {
    }
}
