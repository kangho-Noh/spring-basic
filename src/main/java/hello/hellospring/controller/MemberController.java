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

    @Autowired // Autowired 어노테이션이 있으면 스프링이 스프링 컨테이너에서 이미 있는 객체를 가지고 와서 들고 있는다. (새로 생성하는 게 아니라)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        //param을 MemberForm으로 받으면 스프링은 해당 클래스가 정의된 곳을 찾아
        //html에서 form 안에 input 태그들의 name속성이 가진 변수 이름들과 MemberForm에 있는 변수 이름이 매칭되는 것들을 찾아 setXxx 함수로 값을 넣어준다.
        //이를 자바 빈 프로퍼티 규약이라고 한다.
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member.getName() = " + member.getName());
        
        memberService.join(member);

        return "redirect:/"; //home 화면으로 리다이렉트
        //리다이렉트를 하는 이유는 post/redirect/get 검색 ㄱ
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
