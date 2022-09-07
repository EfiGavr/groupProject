package groupproject.projectx.dtos;

import groupproject.projectx.model.Flight;
import groupproject.projectx.model.Pilot;

public class PilotFlightDto {

    private Integer pilotFlightId;

    private Flight flight;

    private Pilot pilot;

    public PilotFlightDto() {
    }

    public PilotFlightDto(Integer pilotFlightId, Flight flight, Pilot pilot) {
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
}
