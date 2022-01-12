package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    //스프링 빈에 등록되어있는 MemberService 객체를 가져와 넣어준다. -> DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
