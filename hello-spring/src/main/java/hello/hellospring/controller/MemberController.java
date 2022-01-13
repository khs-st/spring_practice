package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //스프링 빈에 등록되어있는 MemberService 객체를 가져와 넣어준다. -> DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    
    //url을 창에다 넣는 방식
    //회원가입 페이지 이동
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //데이터를 form 태그에 넣어 전달할때 사용하는 방식
    //회원가입
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setId(form.getId());
        memberService.join(member);

        return "redirect:/";
    }
    
    //회원 목록 조회
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.selectAllMember();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
