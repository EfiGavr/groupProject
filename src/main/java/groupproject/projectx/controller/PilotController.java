package groupproject.projectx.controller;

import groupproject.projectx.model.Pilot;
import groupproject.projectx.repository.PilotRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    @Autowired
    PilotRepository pilotRepository;

    @GetMapping("/allpilots")
    public ResponseEntity<List<Pilot>> getAllPilots() {
        List<Pilot> allPilots = new ArrayList();
        try {
            allPilots = pilotRepository.findAll();
            return new ResponseEntity<>(allPilots, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(allPilots, HttpStatus.BAD_REQUEST);
        }

    }

}

