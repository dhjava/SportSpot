package com.dh.sportspot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/free/list")
    public String FreeList() {
        return "board/free/list";
    }
    @GetMapping("/free/view")
    public String FreeView() {
        return "board/free/view";
    }

    @GetMapping("/free/write")
    public String FreeWrite() {
        return "board/free/write";
    }

    @GetMapping("/free/modify")
    public String FreeModify() {
        return "board/free/modify";
    }

    @GetMapping("/notice/list")
    public String NoticeList() {
        return "board/notice/list";
    }
    @GetMapping("/notice/view")
    public String NoticeView() {
        return "board/notice/view";
    }

    @GetMapping("/notice/write")
    public String NoticeWrite() {
        return "board/notice/write";
    }

    @GetMapping("/notice/modify")
    public String NoticeModify() {
        return "board/notice/modify";
    }
}
