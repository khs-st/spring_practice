package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다!
@ComponentScan(
        //basePackages -> 탐색할 패키지의 시작 위치를 지정, 이 패키지 포함 하위 패키지를 모두 탐색한다.
        //basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

    //만약 수동 빈 등록과 자동 빈 등록에서 빈 이름이 충돌되면 어떻게 될까?
    //수동 빈 등록이 우선권을 가진다.(수동 빈이 자동 빈을 오버라이딩 해버린다.)
    //수동 빈 등록시 로그가 남는다.
    //스프링 부트인 CoreApplication 을 실행해보면 오류를 볼 수 있다.
/*    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/
}
