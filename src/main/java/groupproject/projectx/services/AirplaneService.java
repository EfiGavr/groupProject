/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.services;

import groupproject.projectx.model.Airplane;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ironm
 */
public interface AirplaneService {
    ResponseEntity<List<Airplane>> getAllAirplanes();
    ResponseEntity<Airplane> getAirplaneById(int id);
    ResponseEntity<List<Airplane>> getAirplaneByManufacture(String manufacture);
    ResponseEntity<List<Airplane>> getAirplaneByModelNumber(String modelNumber);
    ResponseEntity<List<Airplane>> getAirplaneByCapacity(int capacity);
}
