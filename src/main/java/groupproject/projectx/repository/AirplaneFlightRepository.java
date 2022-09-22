
package groupproject.projectx.repository;

import groupproject.projectx.model.AirplaneFlight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneFlightRepository extends JpaRepository<AirplaneFlight, Integer> {
    List<AirplaneFlight> findAllByAirplane_AirplaneId(Integer airplaneId);
    List<AirplaneFlight> findByAirplane_Manufacture(String manufacture);
    List<AirplaneFlight> findByAirplane_ModelNumber(String modelNumber);
    List<AirplaneFlight> findByAirplane_Capacity(Integer capacity);
    List<AirplaneFlight> findByFlight_DepartureBetween(LocalDateTime departureDate, LocalDateTime departureDate2);
    List<AirplaneFlight> findByFlight_ArrivalBetween(LocalDateTime arrivalDate, LocalDateTime arrivalDate2);


}
