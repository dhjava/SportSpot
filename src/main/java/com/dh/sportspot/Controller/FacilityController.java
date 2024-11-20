package com.dh.sportspot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @GetMapping("/futsal/list")
    public String list() {
        return "facility/futsal/list";
    }

    @GetMapping("/futsal/view")
    public String view() {
        return "facility/futsal/view";
    }

    @GetMapping("/futsal/write")
    public String write() {
        return "facility/futsal/write";
    }

    @GetMapping("/futsal/modify")
    public String modify() {
        return "facility/futsal/modify";
    }
}
