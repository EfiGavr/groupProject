package groupproject.projectx.repository;

import groupproject.projectx.model.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAllByRole(String role);

    List<Client> findAllByTelephoneNumber(String telephoneNumber);

    List<Client> findAllByEmail(String email);

    List<Client> findAllByFname(String fname);

    List<Client> findAllByLname(String lname);


}
