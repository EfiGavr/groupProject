package groupproject.projectx.controller;

import groupproject.projectx.dtos.ClientTicketDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.dtos.TicketDto;
import groupproject.projectx.model.Client;
import groupproject.projectx.model.ClientTicket;
import groupproject.projectx.repository.ClientRepository;
import groupproject.projectx.repository.ClientTicketRepository;
import groupproject.projectx.repository.TicketRepository;
import groupproject.projectx.services.ClientTicketService;
import groupproject.projectx.services.EmailService;
import groupproject.projectx.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/clientTicket")
public class ClientTicketController {

    @Autowired
    private ClientTicketService clientTicketService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String from;

    @GetMapping("/allClientTickets")
    public ResponseEntity<GenericResponse> getAllClientTickets() {
        List<ClientTicketDto> allClientTickets = new ArrayList();
        try {
            allClientTickets = clientTicketService.getAllClientTicket();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "List of Client - Tickets Successfully Found", allClientTickets));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Client - Tickets List", null));
        }
    }

    @GetMapping("/clientTicket/{id}")
    public ResponseEntity<GenericResponse> getClientTicketById(@PathVariable("id") Integer clientTicketId) {

        ClientTicketDto clientTicketDto = new ClientTicketDto();
        try {
            clientTicketDto = clientTicketService.getClientTicketDtoById(clientTicketId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/clientTicketByTicketId")
    public ResponseEntity<GenericResponse> getClientTicketByTicketId(
            @RequestParam("ticketId") Integer ticketId) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByTicketId(ticketId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Tickets Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/fare")
    public ResponseEntity<GenericResponse> getClientTicketByTicketFare(
            @RequestParam("fare") BigDecimal fare) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByFare(fare);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Tickets Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/clientTicketByFlightId")
    public ResponseEntity<GenericResponse> getClientTicketByFlightId(
            @RequestParam("flightId") Integer flightId) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByFlightId(flightId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/clientTicketByClientId")
    public ResponseEntity<GenericResponse> getClientTicketByClientId(
            @RequestParam("clientId") Integer clientId) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketDtoByClientId(clientId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/telephone")
    public ResponseEntity<GenericResponse> getClientTicketByTelephone(
            @RequestParam("telephone") String telephone) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByClientTelephone(telephone);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/email")
    public ResponseEntity<GenericResponse> getClientTicketByEmail(
            @RequestParam("email") String email) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByClientEmail(email);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/fname")
    public ResponseEntity<GenericResponse> getClientTicketByFname(
            @RequestParam("fname") String fname) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByClientFname(fname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/lname")
    public ResponseEntity<GenericResponse> getClientTicketByLname(
            @RequestParam("lname") String lname) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByClientLname(lname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/role")
    public ResponseEntity<GenericResponse> getClientTicketByRole(
            @RequestParam("role") String role) {
        List<ClientTicketDto> clientTicketDtos = new ArrayList<>();
        try {
            clientTicketDtos = clientTicketService.getClientTicketByRole(role);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client - Ticket Successfully Found", clientTicketDtos));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client - Ticket", null));
        }
    }

    @PostMapping("/createClientTicket")
    public ResponseEntity<GenericResponse> setTicketToClient(
            @RequestParam("clientId") Integer clientId,
            @RequestParam("flightId") Integer flightId
    ) {
        try {
            Optional<Client> clientOptional = clientRepository.findById(clientId);
            Client client = new Client();
            if (clientOptional.isPresent()) {
                client = clientOptional.get();
            } else {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Client-Ticket. Client not found", null));
            }
            TicketDto ticketDto = ticketService.getAvailiableTicketByFlight(flightId, false);
            ClientTicket clientTicket = clientTicketService.createClientTicket(clientId, ticketDto.getTicketId());
            emailService.sendMail(from, client.getEmail(), "Booking Confirmation", "\n" +
                    "Dear " + client.getLname() + " " + client.getFname() + ", " + "we would like to inform you that your ticket was successfully booked with ticket code : " +
                    clientTicket.getTicket().getTicketId() + " and the code of your flight is " + flightId + ". We wish you a pleasant trip !!!");
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client-Ticket Successfully Created and E-Mail Sent ", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Client-Ticket", null));
        }
    }

    @PostMapping("/deleteClientTicket")
    public ResponseEntity<GenericResponse> deleteClientTicket(
            @RequestBody ClientTicketDto clientTicketDto) {
        try {
            Client client = clientRepository.findByClientTicketSet_ClientTicketId(clientTicketDto.getClientTicketId());
            ticketService.deleteTicketByClientId(client.getClientId());
            clientTicketService.deleteClientTicket(clientTicketDto.getClientTicketId());
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client-Ticket Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Client-Ticket", null));
        }
    }

//   SOMETHING THAT IS NOT GOING TO BE USED

//    @PostMapping("/updateClientTicket")
//    public ResponseEntity<GenericResponse> updateClientTicket(
//            @RequestBody ClientTicketDto clientTicketDto) {
//        try {
//            ClientTicketDto clientTicketDtoUpdated = clientTicketService.updateClientTicket(clientTicketDto);
//            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client-Ticket Successfully Updated", null));
//        } catch (Exception ex) {
//            if (ex instanceof EntityNotFoundException) {
//                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
//            }
//            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Updating Client-Ticket", null));
//        }
//    }
}
