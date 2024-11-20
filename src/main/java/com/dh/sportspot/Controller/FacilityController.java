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
}
