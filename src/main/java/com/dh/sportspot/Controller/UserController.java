package com.dh.sportspot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("login")
    public String login() {
        return "user/login";
    }

    @GetMapping("signup")
    public String signup() {
        return "user/signup";
    }

    @GetMapping("idFind")
    public String idFind() {
        return "user/idFind";
    }

    @GetMapping("idFind-submit")
    public String idFindSubmit() {
        return "user/idFind-submit";
    }

    @GetMapping("pwFind")
    public String pwFind() {
        return "user/pwFind";
    }
}
