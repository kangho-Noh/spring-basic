package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // Autowired 어노테이션이 있으면 스프링이 스프링 컨테이너에서 이미 있는 객체를 가지고 와서 들고 있는다. (새로 생성하는 게 아니라)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
