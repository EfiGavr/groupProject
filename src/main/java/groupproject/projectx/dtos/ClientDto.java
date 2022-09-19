package groupproject.projectx.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
    
    private Integer clientId;
    private String telephoneNumber;
    private String email;
    private String fname;
    private String lname;
    private String role;

    private String username;

    private String password;

    public ClientDto() {
    }

    public ClientDto(String telephoneNumber, String email, String fname, String lname, String role) {
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }
    
}
