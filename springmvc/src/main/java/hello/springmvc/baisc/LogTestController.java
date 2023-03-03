package hello.springmvc.baisc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 는 반환 값으로 뷰를 찾는 것이 아니라
// HTTP 메시지 바디에 바로 입력한다.
// 따라서 실행 결과로 메시지를 받을 수 있다.
//@Slf4j
@RestController
public class LogTestController {

    //@Slf4j 어노테이션 선언 시 아래 선언 안해도 된다.
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    private String logTest(){

        String name = "test";

        // LEVEL:  TRACE > DEBUG > INFO > WARN > ERROR
        /*
            #로그 사용 시 장점
            1. 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 출력 모양을 조정할 수 있다.
            2. 로그 레벨에 따라 개발 서버에서는 모든 로그를 출력하고,
                운영서버에서는 출력하지 않는 등 로그를 상황에 맞게 조절가능하다.
            3. 시스템 아웃 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등, 로그를 별도의 위치에 남길 수 있다.
            4. 특히 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다.
            5. 성능도 일반 System.out 보다 좋다.
                (내부 버퍼링, 멀티 쓰레드 등등) 그래서 실무에서는 꼭 로그를 사용해야 한다.
         */

        log.trace(" trace log-test name={} ", name);
        //개발 서버는 debug
        log.debug(" debug log-test name={} ", name);
        // 운영 서버는 info 출력
        log.info(" info log-test name={} " ,name);
        log.warn(" warn log-test name={} " ,name);
        log.error(" error log-test name={} " ,name);

        return "log-test";
    }
}
