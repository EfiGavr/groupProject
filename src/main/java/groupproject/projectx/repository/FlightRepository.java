package groupproject.projectx.repository;

import groupproject.projectx.model.Flight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAllByDepartureBetween(LocalDateTime departureStartDate, LocalDateTime departureEndDate);

    List<Flight> findAllByArrivalBetween(LocalDateTime arrivalStartDate, LocalDateTime arrivalEndDate);

//    List<Flight> findAllByFlightId_Flight(Flight flightId);


}
