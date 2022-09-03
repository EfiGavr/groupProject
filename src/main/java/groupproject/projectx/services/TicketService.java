
package groupproject.projectx.services;

import groupproject.projectx.model.Flight;
import groupproject.projectx.model.Ticket;
import groupproject.projectx.repository.FlightRepository;
import groupproject.projectx.repository.TicketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    
     @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
}
