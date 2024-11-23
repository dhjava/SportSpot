package com.dh.sportspot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    @GetMapping("signup")
    public String signup() {
        return "member/signup";
    }

    @GetMapping("idFind")
    public String idFind() {
        return "member/idFind";
    }

    @GetMapping("idFind-submit")
    public String idFindSubmit() {
        return "member/idFind-submit";
    }

    @GetMapping("pwFind")
    public String pwFind() {
        return "member/pwFind";
    }
}
