package hello.core;

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
}
