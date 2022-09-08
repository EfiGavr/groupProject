package groupproject.projectx.services;

import groupproject.projectx.dtos.MemberDto;
import groupproject.projectx.model.Member;
import groupproject.projectx.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    MemberRepository memberRepository;
    
    public List<MemberDto> getAllMembers() {
        return convertToDtoList(memberRepository.findAll());
    }
    
    public List<MemberDto> getAllMembersByBonus(Integer bonus) {
        return convertToDtoList(memberRepository.findAllByBonus(bonus));
    }
    
    public void createMember(MemberDto memberDto) {
        Member newMember = convertToMember(memberDto);
        memberRepository.save(newMember);
    }
    
    public void deleteMember(MemberDto memberDto) {
        memberRepository.deleteById(convertToMember(memberDto).getMemberId());
    }
    
    public MemberDto updateMember(MemberDto updatedMemberDto) {
        Optional<Member> memberOptional = memberRepository.findById(updatedMemberDto.getMemberId());
        if (memberOptional.isPresent()) {
            Member member = convertToMember(updatedMemberDto);
            memberRepository.save(member);
            return updatedMemberDto;
        } else {
            throw new EntityNotFoundException ("Client Not Found");
        }
    }
    
    public Member convertToMember(MemberDto memberDto) {
        return modelMapper.map(memberDto, Member.class);
    }
    
    public List<MemberDto> convertToDtoList(List<Member> members) {
        TypeToken<List<MemberDto>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(members, typeToken.getType());
    }
}
