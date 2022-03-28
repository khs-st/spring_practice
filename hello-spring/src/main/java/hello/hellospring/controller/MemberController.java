package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import lombok.RequiredArgsConstructor;

//자 이부분 아주 좋은 부분입니다. 생성자를 통한 DI
//여기서 개꿀팁 lombok을 사용해서 위의 @RequiredArgsConstructor 이걸 설정해준다면
//알아서 생성자 주입을 해줍니다. 단 final이 붙은 멤버인스턴스에 대해서만.
//그러므로 밑의 @Autowired 통산 생성자 주입방식을 코딩하지않아도 자동 주입됨.
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    //스프링 빈에 등록되어있는 MemberService 객체를 가져와 넣어준다. -> DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
        //실제 프록시 주입되는지 sout으로 확인
        //System.out.println("MemberService = " + memberService.getClass());
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

        // Memeber domain에 @Builder 어노테이션을 선언해주었기에
        // 밑의 setter를 이용해서 데이터를 저장 하지 않고 빌드 패턴을 이용하여 저장해주면 개간지 ㅇㅈ?
        memberService.join(Memeber.builder()
                .id(form.getId())
                .name(form.getName())
                .build());

    //    Member member = new Member();
    //    member.setName(form.getName());
    //    member.setId(form.getId());
    //    memberService.join(member);

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
