/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.repository;

import groupproject.projectx.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dream
 */
public interface PilotRepository extends JpaRepository<Pilot,Integer>{
    
}
