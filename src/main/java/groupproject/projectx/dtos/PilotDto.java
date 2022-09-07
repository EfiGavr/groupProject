package groupproject.projectx.dtos;

public class PilotDto {

    private Integer pilotId;

    private String fname;

    private String lname;

    private String contactNumber;

    private Integer licenceNumber;

    public PilotDto() {
    }

    public PilotDto(String fname, String lname, String contactNumber, Integer licenceNumber) {
        this.fname = fname;
        this.lname = lname;
        this.contactNumber = contactNumber;
        this.licenceNumber = licenceNumber;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Integer licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
