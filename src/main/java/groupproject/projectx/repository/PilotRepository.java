
package groupproject.projectx.repository;

import groupproject.projectx.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotRepository extends JpaRepository<Pilot, Integer> {

    List<Pilot> findAllByFname(String fname);

    List<Pilot> findAllByLname(String lname);

    Pilot findByLicenceNumber(Integer licenceNumber);

    List<Pilot> findAllByContactNumber(String contactNumber);



}
