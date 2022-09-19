package groupproject.projectx.repository;

import groupproject.projectx.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByAdUsernameAndAdPassword(String adUsername, String adPassword);


}
