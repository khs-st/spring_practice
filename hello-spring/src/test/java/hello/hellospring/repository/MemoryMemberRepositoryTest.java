package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트 실행, 종료 시 데이터 초기화 필요함
    //테스트는 순서와 관계없이, 서로 의존관계 없이 설계가 되어야 한다.
    //그러기 위해선 하나의 테스트가 실행되면 공용 데이터는 지워져야한다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    //회원 리포지토리 테스트 케이스 작성
    @Test
    public void save() {
        Member member = new Member();
        member.setName("kobalja");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("고한솔1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("고한솔2");
        repository.save(member2);

        Member result = repository.findByName("고한솔1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("kobalja1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kobalja2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
