package groupproject.projectx.services;

import groupproject.projectx.model.Pilot;
import groupproject.projectx.repository.PilotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotService {

    @Autowired
    PilotRepository pilotRepository;

    public List<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }
}
