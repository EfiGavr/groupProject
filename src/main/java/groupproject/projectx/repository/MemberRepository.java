package groupproject.projectx.repository;

import groupproject.projectx.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer>{
    
    List<Member> findAllByBonus(Integer bonus);
}
