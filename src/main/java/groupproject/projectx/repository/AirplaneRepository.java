
package groupproject.projectx.repository;

import groupproject.projectx.model.Airplane;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

    List<Airplane> findByManufactureContaining(String manufacture);

    List<Airplane> findByModelNumber(String modelNumber);

    List<Airplane> findByCapacity(Integer capacity);

    Airplane findByAirplaneFlightSet_Flight_FlightId(Integer flightId);


}
