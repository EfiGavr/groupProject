
package groupproject.projectx.dtos;

public class AirplaneFlightDto {
    private Integer airplaneFlightId;
    private AirplaneDto airplane;
    private FlightDto flight;

    public Integer getAirplaneFlightId() {
        return airplaneFlightId;
    }

    public void setAirplaneFlightId(Integer airplaneFlightId) {
        this.airplaneFlightId = airplaneFlightId;
    }

    public AirplaneDto getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneDto airplane) {
        this.airplane = airplane;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }
    
    
}
