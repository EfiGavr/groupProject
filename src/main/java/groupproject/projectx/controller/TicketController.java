
package groupproject.projectx.controller;

import groupproject.projectx.model.Flight;
import groupproject.projectx.model.Ticket;
import groupproject.projectx.services.TicketService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tickets")
public class TicketController {
    
     @Autowired
     private TicketService ticketService;
    
     @GetMapping("/alltickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> allTickets = new ArrayList();
        try {
            allTickets = ticketService.getAllTickets();
            return new ResponseEntity<>(allTickets, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allTickets, HttpStatus.BAD_REQUEST);
        }
}
    
    
    
     @PostMapping("tickets/delete/{id}")
    public String deleteTickets(@PathVariable Integer id, ModelMap model) {
        
        Ticket t = ticketService.findById(id);
        ticketService.delete(t);

        model.addAttribute("trainersList", ticketService.findAll());

        return "redirect:/tickets";
    }
}