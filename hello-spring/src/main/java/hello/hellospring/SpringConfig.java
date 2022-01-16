package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;
import javax.xml.crypto.Data;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    //SpringDataJpaMemberRepository 추가
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em =em;
    }*/

/*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
*/

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
//       return new MemoryMemberRepository();
//       Repository 변경
//       return new JdbcMemberRepository(dataSource);
//       JdbcTemplateMemberRepository로 변경
//       return new JdbcTemplateMemberRepository(dataSource);
//       JpaMemberRepository로 변경
//       return new JpaMemberRepository(em);
//    }
    //@Componenet 안쓸경우
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
