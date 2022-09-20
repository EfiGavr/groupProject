package groupproject.projectx.repository;

import groupproject.projectx.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Integer> {

    List<Airport> findAllByCountry(String country);

    List<Airport> findAllByCity(String city);

    List<Airport> findAllByAirportname(String airportname);

    Airport findByAirportname(String airportname);




}
