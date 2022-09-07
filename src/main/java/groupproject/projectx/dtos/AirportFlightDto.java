package groupproject.projectx.dtos;


public class AirportFlightDto {

    private Integer airportFlightId;

    private AirportDto from1;

    private AirportDto to;

    private FlightDto flight;

    public Integer getAirportFlightId() {
        return airportFlightId;
    }

    public void setAirportFlightId(Integer airportFlightId) {
        this.airportFlightId = airportFlightId;
    }

    public AirportDto getFrom1() {
        return from1;
    }

    public void setFrom1(AirportDto from1) {
        this.from1 = from1;
    }

    public AirportDto getTo() {
        return to;
    }

    public void setTo(AirportDto to) {
        this.to = to;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }
}
