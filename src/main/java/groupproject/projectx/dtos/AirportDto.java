package groupproject.projectx.dtos;

public class AirportDto {

    private Integer airportId;

    private String country;

    private String city;

    private String airportname;

    public AirportDto() {
    }

    public AirportDto(String country, String city, String airportname) {
        this.country = country;
        this.city = city;
        this.airportname = airportname;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }
}
