package hello.springmvc.baisc.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request,
                               HttpServletResponse response) throws IOException{

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int age) {

        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {

        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {

        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                        @RequestParam(required = false) int age) {
        // required = true 라면 필수 값
        // int 같은 기본형(primitive)에는 null 값 들어갈 수 있도록 형변환(Integer 아용)하거나 defaultValue 사용
        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                        @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username={}, age={}",username,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));

        return "ok";
    }


}
