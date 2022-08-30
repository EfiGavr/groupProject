/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package groupproject.projectx.repository;

import groupproject.projectx.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dream
 */
public interface MemberRepository extends JpaRepository<Members,Integer>{
    
}
