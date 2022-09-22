package groupproject.projectx.dtos;


public class PilotFlightDto {

    private Integer pilotFlightId;

    private FlightDto flight;

    private PilotDto pilot;

    public PilotFlightDto() {
    }

    public PilotFlightDto(Integer pilotFlightId, FlightDto flight, PilotDto pilot) {
        this.pilotFlightId = pilotFlightId;
        this.flight = flight;
        this.pilot = pilot;
    }

    public Integer getPilotFlightId() {
        return pilotFlightId;
    }

    public void setPilotFlightId(Integer pilotFlightId) {
        this.pilotFlightId = pilotFlightId;
    }

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
    }

    public PilotDto getPilot() {
        return pilot;
    }

    public void setPilot(PilotDto pilot) {
        this.pilot = pilot;
    }
}
