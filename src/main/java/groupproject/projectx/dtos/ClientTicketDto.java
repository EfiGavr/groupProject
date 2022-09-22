package groupproject.projectx.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientTicketDto {

    private Integer clientTicketId;

    private ClientDto client;

    private TicketDto ticket;

    public ClientTicketDto() {
    }
}
