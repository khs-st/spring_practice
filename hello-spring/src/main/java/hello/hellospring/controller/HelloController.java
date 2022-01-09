package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //직접 파라미터 받기
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hi! Spring!");
        return "hello";
    }
    //외부(웹)에서 파라미터 값 받기
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        //key=name 와 value=name
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    //@ResponseBody 문자 반환 -@ResponseBody는 http에서 body부분에 data를 직접 넣어주겠다는 의미이다.
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model){
        //return값이 그대로 반환된다.
        // -> 매핑값 실행 시(http://localhost:8080/hello-string?name=kobalja) 결과 값은 hellokobalja
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //메서드 사용하여 접근
        Hello hello = new Hello();
        hello.setName(name);
        //@ResponseBody를 사용하고, 문자가 아닌 객체를 반환하면 객체가 JSON으로 변환돤다.
        //출력결과 -> {"name":"spring"}
        return hello;
    }

    static class Hello{
        //private는 외부에서 사용불가능하다.
        private String name;
        //Getter, Setter 설정, 프로퍼티 접근 방식이다.
        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name=name;
        }
    }

}
