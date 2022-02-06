package hello.core.member;

/**
 * 회원 서비스 구현체
 */
public class MemberServiceImpl implements MemberService{

    //회원 도메인 설계의 문제점
    //다른 저장소 변경 시 OCP 원칙 위반
    //현재 의존관계가 인터페이스뿐만이 아니라 구현까지 모두 의존하는 문제가 있다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //해결을 위해 수정
    //MemberServiceImpl 은 MemoryMemberRepository 를 의존하지 않는다!
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
