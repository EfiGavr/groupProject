/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject.projectx.services;

import groupproject.projectx.exception.ResourceNotFoundException;
import groupproject.projectx.model.Airplane;
import groupproject.projectx.repository.AirplaneRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author ironm
 */
@Service
public class AirplaneServiceImplementation implements AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        List<Airplane> airplanes = airplaneRepository.findAll();
        if (airplanes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Airplane> getAirplaneById(int id) {
        Airplane airplane = airplaneRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Not found airplane with id = " + id));
                
        return new ResponseEntity<>(airplane, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Airplane>> getAirplaneByManufacture(String manufacture) {
        List<Airplane> airplanes = new ArrayList<Airplane>();

        if (manufacture == null) {
            airplaneRepository.findAll().forEach(airplanes::add);
        } else {
            airplaneRepository.findByManufactureContaining(manufacture).forEach(airplanes::add);
        }
        if (airplanes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Airplane>> getAirplaneByModelNumber(String modelNumber) {
        List<Airplane> airplanes = new ArrayList<Airplane>();

        if (modelNumber == null) {
            airplaneRepository.findAll().forEach(airplanes::add);
        } else {
            airplaneRepository.findByModelNumber(modelNumber).forEach(airplanes::add);
        }
        if (airplanes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Airplane>> getAirplaneByCapacity(int capacity) {
        List<Airplane> airplanes = new ArrayList<Airplane>();

        if (capacity == 0) {
            airplaneRepository.findAll().forEach(airplanes::add);
        } else {
            airplaneRepository.findByCapacity(capacity).forEach(airplanes::add);
        }
        if (airplanes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }
}
