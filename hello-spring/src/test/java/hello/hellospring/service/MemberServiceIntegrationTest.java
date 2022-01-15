package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//통합테스트
// 스프링 컨테이너와 테스트를 함께 실행한다.
@SpringBootTest
// @Transactional로 테스트 시작 전 트랜잭션 실행시켜 테스트 완료 후 롤백시켜 데이터 지워준다.
// -> 다음 테스트 반복 가능(기존에는 지웠어야 반복이 가능 했다.)
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

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