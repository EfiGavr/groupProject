package groupproject.projectx.controller;

import groupproject.projectx.dtos.*;
import groupproject.projectx.services.ClientService;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import groupproject.projectx.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    TicketService ticketService;


    @GetMapping("/allClients")
    public ResponseEntity<GenericResponse> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClients();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client List Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client List", null));
        }
    }

    @GetMapping("/clientid/{id}")
    public ResponseEntity<GenericResponse> getClientById(
            @PathVariable("id") Integer clientId) {
        new ClientDto();
        ClientDto client;
        try {
            client = clientService.getClientById(clientId);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Found", client));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Client", null));
        }
    }

    @PostMapping("/role")
    public ResponseEntity<GenericResponse> getAllClientsByRole(
            @RequestParam("role") String role) {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClientsByRole(role);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Role List Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client Role List", null));
        }
    }

    @PostMapping("/telephone")
    public ResponseEntity<GenericResponse> getAllClientsByTelephone(
            @RequestParam("telephone") String telephone) {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClientsByTelephone(telephone);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Clients Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Clients", null));
        }
    }

    @PostMapping("/email")
    public ResponseEntity<GenericResponse> getAllClientsByEmail(
            @RequestParam("email") String email) {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClientsByEmail(email);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Clients Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Clients", null));
        }
    }

    @PostMapping("/fname")
    public ResponseEntity<GenericResponse> getAllClientsByFname(
            @RequestParam("fname") String fname) {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClientsByFname(fname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Clients Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Clients", null));
        }
    }

    @PostMapping("/lname")
    public ResponseEntity<GenericResponse> getAllClientsByLname(
            @RequestParam("lname") String lname) {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClientsByLname(lname);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Clients Found", clients));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Clients", null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createClient(
            @RequestBody ClientDto clientDto) {
        try {
            //TODO  check if client's mail already exists
            clientService.createClient(clientDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Successfully Created", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Creating Client", null));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<GenericResponse> deleteClient(
            @RequestBody ClientDto clientDto) {
        try {
            //Delete first all the related client - ticket relationships and the tickets
            if (clientService.existRelatedClientTicket(clientDto.getClientId())) {
                ticketService.deleteTicketByClientId(clientDto.getClientId());
                clientService.deleteClient(clientDto.getClientId());
                return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Successfully Deleted After Deleting All the Relative Client - Tickets and Tickets", null));
            }
            clientService.deleteClient(clientDto.getClientId());
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Client", null));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<GenericResponse> updateClient(
            @RequestBody ClientDto clientDto) {
        try {
            clientService.updateClient(clientDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client Successfully Updated", clientDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Updatind Client", clientDto));
        }
    }
}
