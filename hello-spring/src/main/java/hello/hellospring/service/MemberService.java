package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * 회원 가입
     */
    public Long join(Member member){
        
        //동일한 이름 즉, 중복 이름으로 회원 가입 불가능하도록
        // Optional 메서드 사용
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //동일한 이름 즉, 중복 이름으로 회원 가입 불가능하도록
    // Optional 메서드 사용
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("회원이 이미 존재합니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> selectAllMember(){
         return memberRepository.findAll();
    }

    public Optional<Member> selectOneMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}
