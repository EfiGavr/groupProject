/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.repository;

import groupproject.projectx.model.Airplane;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dream
 */
public interface AirplaneRepository extends JpaRepository<Airplane,Integer>{
    
    List<Airplane> findByManufactureContaining(String manufacture);
    List<Airplane> findByModelNumber(String modelNumber);
    List<Airplane> findByCapacity(int capacity);
}
