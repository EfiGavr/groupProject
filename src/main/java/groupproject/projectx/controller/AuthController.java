package groupproject.projectx.controller;

import groupproject.projectx.dtos.AdminDto;
import groupproject.projectx.dtos.ClientDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.services.AdminService;
import groupproject.projectx.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    ClientService clientService;

    @Autowired
    AdminService adminService;

    @PostMapping("/loginadmin")
    public ResponseEntity<GenericResponse> loginAdmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        AdminDto adminDto = new AdminDto();
        try {
            adminDto = adminService.getAdminByCredentials(username, password);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Successfully Log In As Admin", adminDto));
        } catch (Exception ex) {
            if (ex instanceof IllegalArgumentException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Member", null));
        }
    }

    @PostMapping("/loginclient")
    public ResponseEntity<GenericResponse> loginClient(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        ClientDto clientDto = new ClientDto();
        try {
            clientDto = clientService.getClientByCredentials(username, password);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Successfully Log In As Client", clientDto));
        } catch (Exception ex) {
            if (ex instanceof IllegalArgumentException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Client", null));
        }
    }
}
