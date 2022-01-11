package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    
    //MemberService 메서드 사용 위해서
    //MemberService memberService = new MemberService();
    //데이터 중복 막기 위해서
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    //MemberService의 코드 수정으로 인해서 여기도 수정
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    //동일한 memberRepository 사용
    //@BeforeEach -> 각 테스트 실행 전에 호출된다.
    //테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고,
    //의존관계도 새로 맺어준다.
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //종료 시 데이터 초기화
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    /**
     * 회원 가입 테스트
     */
    @Test
    void join() {
        //given - 어떤 데이터 기반
        Member member = new Member();
        member.setName("Test1");

        //when - 어떤걸 검증하는지
        Long saveId = memberService.join(member);

        //then - 결과는 어떻게 되는지
        Member selectMember = memberService.selectOneMember(saveId).get();
        assertThat(member.getName()).isEqualTo(selectMember.getName());
    }

    /**
     * 회원 이름 중복 테스트
     */
    @Test
    public void duplicateMember(){
        //given
        Member member1=new Member();
        member1.setName("Test1");

        Member member2=new Member();
        member2.setName("Test1");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("중복된 회원입니다.");
        //assertThrows(IllegalStateException.class,() -> memberService.join(member2));
/*        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("중복된 회원입니다.");
        }*/

        //then
    }

    /**
     * 전체 회원 조회 테스트
     */
    @Test
    void selectAllMember() {

    }

    /**
     * 회원 단일 조회 테스트
     */
    @Test
    void selectOneMember() {

    }
}