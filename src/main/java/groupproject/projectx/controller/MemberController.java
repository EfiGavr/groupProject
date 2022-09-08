package groupproject.projectx.controller;

import groupproject.projectx.dtos.GenericResponse;
import groupproject.projectx.dtos.MemberDto;
import groupproject.projectx.services.MemberService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    MemberService memberService;
    
    @GetMapping("/allMembers")
    public ResponseEntity<GenericResponse> getAllMembers() {
        List<MemberDto> members = new ArrayList<>();
        try {
            members = memberService.getAllMembers();
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Member List Found", members));
        } catch (Exception ex){
            if (ex instanceof EntityNotFoundException) {
                ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Member List", null));
        }
    }
    
    @PostMapping("/bonus")
    public ResponseEntity<GenericResponse> getAllMembersByBonus(
        @RequestParam ("bonus") Integer bonus) {
        List<MemberDto> members = new ArrayList<>();
        try {
            members = memberService.getAllMembersByBonus(bonus);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Member Bonus List Found", members));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Searching Member Bonus List", null));
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createMember(
        @RequestBody MemberDto memberDto) {
        try {
            memberService.createMember(memberDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Member Successfully Created", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Creating Member", null));
        }
    }
    
    @PostMapping("/delete")
    public ResponseEntity<GenericResponse> deleteMember(
        @RequestBody MemberDto memberDto) {
        try {
            memberService.deleteMember(memberDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Member Successfully Deleted", null));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Deleting Member", null));
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<GenericResponse> updateMember(
        @RequestBody MemberDto memberDto) {
        try {
            memberService.updateMember(memberDto);
            return ResponseEntity.ok().body(new GenericResponse("Succeed", "Member Successfully Updated", memberDto));
        } catch (Exception ex) {
            if (ex instanceof EntityNotFoundException) {
                return ResponseEntity.badRequest().body(new GenericResponse("Error", ex.getMessage(), null));
            }
            return ResponseEntity.badRequest().body(new GenericResponse("Error", "Error While Updatind Member", memberDto));
        }
    }
    
}
