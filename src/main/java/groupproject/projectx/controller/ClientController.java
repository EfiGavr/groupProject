package groupproject.projectx.controller;

import groupproject.projectx.dtos.ClientDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.services.ClientService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    ClientService clientService;
    
    @GetMapping("/allClients")
    public ResponseEntity<GenericResponse> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        try {
            clients = clientService.getAllClients();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Client List Found", clients));
        } catch (Exception ex){
            if (ex instanceof EntityNotFoundException) {
                ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client List", null));
        }
    }
    
    @PostMapping("/role")
    public ResponseEntity<GenericResponse> getAllClientsByRole(
        @RequestParam ("role") String role) {
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
    
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createClient(
        @RequestBody ClientDto clientDto) {
        try {
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
            clientService.deleteClient(clientDto);
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
