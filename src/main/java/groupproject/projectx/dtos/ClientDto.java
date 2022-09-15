package groupproject.projectx.dtos;

public class ClientDto {
    
    private Integer clientId;
    private String telephoneNumber;
    private String email;
    private String fname;
    private String lname;
    private String role;

    public ClientDto() {
    }

    public ClientDto(String telephoneNumber, String email, String fname, String lname, String role) {
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }
    
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
