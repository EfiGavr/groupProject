/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.repository;

import groupproject.projectx.model.AirplaneFlight;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ironm
 */
public interface AirplaneFlightRepository extends JpaRepository<AirplaneFlight, Integer> {
    List<AirplaneFlight> findAllByAirplane_AirplaneId(Integer airplaneId);
}
