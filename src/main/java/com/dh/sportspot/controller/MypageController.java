package com.dh.sportspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("/modify")
    public String modify() {
        return "mypage/modify";
    }

    @GetMapping("/memberLeave")
    public String memeberLeave() {
        return "mypage/memberLeave";
    }

    @GetMapping("/myContents/myPlace")
    public String myPlace() {
        return "mypage/myContents/myPlace";
    }

    @GetMapping("/myContents/bookmark")
    public String bookmark() {
        return "mypage/myContents/bookmark";
    }
}
