package groupproject.projectx.repository;

import groupproject.projectx.model.ClientTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ClientTicketRepository extends JpaRepository<ClientTicket, Integer> {

    List<ClientTicket> findAllClientTicketByTicket_TicketIdIs(Integer ticketId);

    List<ClientTicket> findAllClientTicketByTicket_FareIs(BigDecimal fare);

    List<ClientTicket> findByTicket_FlightTicketId_FlightId(Integer flightId);

    List<ClientTicket> findAllClientTicketByClient_ClientIdIs(Integer clientId);

    List<ClientTicket> findAllClientTicketByClient_TelephoneNumberIs(String telephoneNumber);

    List<ClientTicket> findAllClientTicketByClient_EmailIs(String email);

    List<ClientTicket> findAllClientTicketByClient_FnameIs(String fname);

    List<ClientTicket> findAllClientTicketByClient_LnameIs(String lname);

    List<ClientTicket> findAllClientTicketByClient_RoleIs(String role);

    List<ClientTicket> findAllByTicket_TicketId(Integer ticketId);

    boolean existsByClient_ClientId(Integer clientId);

//    List<ClientTicket> findByClient_ClientId(Integer clientId);

}
