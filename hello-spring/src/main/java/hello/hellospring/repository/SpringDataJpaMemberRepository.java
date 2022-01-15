package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//SpringData가 제공
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스만 만들어놓으면 인터패이스에 대한 SpringDataJpa가 인터페이스에 대한 구현체를 만들고 스프링빈에 등록한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
