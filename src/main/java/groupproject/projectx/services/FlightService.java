package groupproject.projectx.services;

import groupproject.projectx.model.Flight;
import groupproject.projectx.repository.FlightRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void insertFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> findByDepartureByDayRange(LocalDateTime departure) {
        return flightRepository.findAllByDepartureBetween(departure, departure.plusHours(24).minusSeconds(1));
    }

    public List<Flight> findByDepartureBetweenTwoDates(LocalDateTime departureStartDate, LocalDateTime departureEndDate) {
        return flightRepository.findAllByDepartureBetween(departureStartDate, departureEndDate.plusHours(24).minusSeconds(1));
    }

    public List<Flight> findByArrivalByDayRange(LocalDateTime arrival) {
        return flightRepository.findAllByArrivalBetween(arrival, arrival.plusHours(24).minusSeconds(1));
    }

    public List<Flight> findByArrivalBetweenTwoDates(LocalDateTime arrivalStartDate, LocalDateTime arrivalEndDate) {
        return flightRepository.findAllByArrivalBetween(arrivalStartDate, arrivalEndDate.plusHours(24).minusSeconds(1));
    }

}

