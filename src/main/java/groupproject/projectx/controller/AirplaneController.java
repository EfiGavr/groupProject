
package groupproject.projectx.controller;

import groupproject.projectx.model.Airplane;
import groupproject.projectx.services.AirplaneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
     
      @Autowired
      AirplaneService airplaneService;
      
      @GetMapping("/airplanes")
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
    return airplaneService.getAllAirplanes();
    }
    
    @GetMapping("/airplanes/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable("id") int id) {
    return airplaneService.getAirplaneById(id);
    }
    
    @GetMapping("/airplanes/{manufacture}")
    public ResponseEntity<List<Airplane>> getAirplanesByManufacture(@PathVariable("manufacture") String manufacture) {
    return airplaneService.getAirplaneByManufacture(manufacture);
    }
    
    @GetMapping("/airplanes/{modelnumber}")
    public ResponseEntity<List<Airplane>> getAirplanesByModelNumber(@PathVariable("modelnumber") String modelNumber) {
    return airplaneService.getAirplaneByModelNumber(modelNumber);
    }
    
    @GetMapping("/airplanes/{capacity}")
    public ResponseEntity<List<Airplane>> getAirplanesByCapacity(@PathVariable("capacity") int capacity){
    return airplaneService.getAirplaneByCapacity(capacity); 
    }
}
