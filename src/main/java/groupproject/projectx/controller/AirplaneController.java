package groupproject.projectx.controller;

import groupproject.projectx.dtos.AirplaneDto;
import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.model.Airplane;
import groupproject.projectx.model.AirplaneFlight;
import groupproject.projectx.repository.AirplaneRepository;
import groupproject.projectx.services.AirplaneFlightService;
import groupproject.projectx.services.AirplaneService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;
    
    @Autowired
    private AirplaneFlightService airplaneFlightService;

    @GetMapping("/airplanes")
    public ResponseEntity<GenericResponse> getAllAirplanes() {
        List<AirplaneDto> allAirplanes;
        try {
            allAirplanes = airplaneService.getAllAirplanes();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane List Found", allAirplanes));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airplane List", null));
        }
    }

    @GetMapping("/airplanes/{id}")
    public ResponseEntity<GenericResponse> getAirplaneById(@PathVariable("id") Integer id) {
        AirplaneDto airplaneDto = new AirplaneDto();
        try {
            airplaneDto = airplaneService.getAirplaneById(id);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane Found", airplaneDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airplane", null));
        }
    }

    @GetMapping("/airplanesmanufacture/{manufacture}")
    public ResponseEntity<GenericResponse> getAirplanesByManufacture(@PathVariable("manufacture") String manufacture) {
        List<AirplaneDto> allAirplanesByManufacture;
        try {
            allAirplanesByManufacture = airplaneService.getAirplanesByManufacture(manufacture);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplanes Found", allAirplanesByManufacture));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airplanes", null));
        }
    }

    @GetMapping("/airplanesmodelnumber/{modelnumber}")
    public ResponseEntity<GenericResponse> getAirplanesByModelNumber(@PathVariable("modelnumber") String modelNumber) {
        List<AirplaneDto> allAirplanesByModelNumber;
        try {
            allAirplanesByModelNumber = airplaneService.getAirplanesByModelNumber(modelNumber);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplanes Found", allAirplanesByModelNumber));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airplanes", null));
        }
    }

    @GetMapping("/airplanescapacity/{capacity}")
    public ResponseEntity<GenericResponse> getAirplanesByCapacity(@PathVariable("capacity") Integer capacity) {
        List<AirplaneDto> allAirplanesByCapacity;
        try {
            allAirplanesByCapacity = airplaneService.getAirplanesByCapacity(capacity);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplanes Found", allAirplanesByCapacity));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Searching Airplanes", null));
        }
    }

    @PostMapping("/createairplane")
    public ResponseEntity<GenericResponse> createnewAirplane(@RequestBody AirplaneDto airplaneDto) {
        try {
            airplaneService.createAirplane(airplaneDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane Successfully Created", null));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Creating Airplane", null));
        }
    }
    
    @PostMapping("/deleteairplane")
    public ResponseEntity<GenericResponse> deleteAirplane(@RequestBody AirplaneDto airplaneDto){
    try {
            airplaneService.deleteAirplane(airplaneDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            airplaneFlightService.deleteAirplaneFlightWhichConnectWithAirplaneToDelete(airplaneDto.getAirplaneId());
            airplaneService.deleteAirplane(airplaneDto);
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Airplane Successfully Deleted, after deleting all the Airplane - Flight Connections", null));
        }
    }
    
    @PostMapping("/updateairplane")
    public ResponseEntity<GenericResponse> updateAirplane(
            @RequestBody AirplaneDto airplaneDto) {
        try {
            airplaneService.updateAirplane(airplaneDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Airplane Successfully Updated", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error while Updating Airplane", null));
        }
    }
    
}
