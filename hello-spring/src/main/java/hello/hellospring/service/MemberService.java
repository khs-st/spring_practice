package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    //static으로 되어 있긴 해서 상관없지만 static이 아니라면 new로 다른 객체로 생성되면
    //다른 인스턴스이기 때문에 내용물이 달라질 가능성이 있다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //위의 문제가 생길 가능성으로 인해서 동일한 인스턴스 사용으로 코드 변경
    private final MemberRepository memberRepository;

    //MemberRepository를 외부에서 넣어주도록 하였다. -> Dependency Injection
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

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
                    throw new IllegalStateException("중복된 회원입니다.");
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
