
package groupproject.projectx.controller;

import groupproject.projectx.dtos.*;
import groupproject.projectx.repository.TicketRepository;
import groupproject.projectx.services.ClientTicketService;
import groupproject.projectx.services.TicketService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClientTicketService clientTicketService;

    @GetMapping("/alltickets")
    public ResponseEntity<GenericResponse> getAllTickets() {
        List<TicketDto> tickets;
        try {
            tickets = ticketService.getAllTickets();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Ticket List Found", tickets));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Ticket List", null));
        }
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<GenericResponse> getTicketById(
            @PathVariable("id") Integer ticketId) {
        new TicketDto();
        TicketDto ticketDto;
        try {
            ticketDto = ticketService.getTicketById(ticketId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Ticket Found", ticketDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Ticket", null));
        }
    }

    @PostMapping("/fare")
    public ResponseEntity<GenericResponse> getAirportsByCountryName(
            @RequestParam("fare") BigDecimal fare) {
        List<TicketDto> ticketDtos;
        try {
            ticketDtos = ticketService.getTicketsByFare(fare);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Tickets Found", ticketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Tickets", null));
        }
    }

    @PostMapping("/ticketsByFlightId")
    public ResponseEntity<GenericResponse> getTicketsByFlightId(
            @RequestParam("flightId") Integer flightId) {
        List<TicketDto> ticketDtos;
        try {
            ticketDtos = ticketService.getTicketsByFlightId(flightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Tickets Found", ticketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Tickets", null));
        }
    }

    @PostMapping("/createTicket")
    public ResponseEntity<GenericResponse> createNewTicket(
            @RequestBody TicketDto ticketDto) {
        try {
            ticketService.createTicket(ticketDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Ticket Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Ticket", null));
        }
    }

    @PostMapping("/updateTicket")
    public ResponseEntity<GenericResponse> updateTicket(
            @RequestBody TicketDto ticketDto) {
        try {
            ticketService.updateTicket(ticketDto);
            return ResponseEntity.ok().body(new GenericResponse("succeed", "Ticket Successfully Updated", ticketDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Ticket update", ticketDto));
        }
    }

    @PostMapping("/deleteTicket")
    public ResponseEntity<GenericResponse> deleteTicket(
            @RequestBody TicketDto ticketDto) {
        try {
            clientTicketService.deleteClientTicketWhichConnectWithTicketToDelete(ticketDto.getTicketId());
            ticketService.deleteTicket(ticketDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Ticket Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            clientTicketService.deleteClientTicketWhichConnectWithTicketToDelete(ticketDto.getTicketId());
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Deleting Ticket", null));
        }
    }

}