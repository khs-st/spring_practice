package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost:8080 요청이 오면 
    //관련 컨트롤러 먼저 찾고(GetMapping 찾기) 호출하고
    //없다면 index.html 호출
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
