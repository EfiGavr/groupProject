package groupproject.projectx.services;

import groupproject.projectx.dtos.AirplaneDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.model.Airplane;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface AirplaneService {
    List<AirplaneDto> getAllAirplanes();
    AirplaneDto getAirplaneById(Integer id);
    List<AirplaneDto> getAirplanesByManufacture(String manufacture);
    List<AirplaneDto> getAirplanesByModelNumber(String modelNumber);
    List<AirplaneDto> getAirplanesByCapacity(Integer capacity);
    void createAirplane(AirplaneDto airplaneDto);
    void deleteAirplane(AirplaneDto airplaneDto);
    AirplaneDto updateAirplane(AirplaneDto updateAirplaneDto);
    AirplaneDto convertToAirplaneDto(Airplane airplane);
    Airplane convertToAirplane(AirplaneDto airplaneDto);
    List<AirplaneDto> convertToDtoList(List<Airplane> airplanes);
    
}
