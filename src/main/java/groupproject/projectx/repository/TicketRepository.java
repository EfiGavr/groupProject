
package groupproject.projectx.repository;

import groupproject.projectx.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer>{


     List<Ticket> findByFare(BigDecimal fare);

     List<Ticket> findByFlightTicketId_FlightId(Integer flightId);

//     List<Ticket> findByClientTicketSet_ClientTicketId(Integer clientTicketId);
//
//     List<Ticket> findByFlightTicketId_DepartureIs(LocalDateTime departure);
//
//     List<Ticket> findByFlightTicketId_Arrival(LocalDateTime arrival);
    

}
