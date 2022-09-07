package groupproject.projectx.repository;

import groupproject.projectx.model.PilotFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotFlightRepository extends JpaRepository<PilotFlight, Integer> {

    List<PilotFlight> findAllByPilot_PilotId(Integer pilotId);
}
