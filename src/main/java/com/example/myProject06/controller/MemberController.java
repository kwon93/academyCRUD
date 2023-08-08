package com.example.myProject06.controller;

import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/list")
    public void list(@RequestParam(defaultValue = "0")int page, Model model){
        Page<MemberDTO> list = memberService.getList(page);
        List<MemberDTO> content = list.getContent();
        model.addAttribute("list",list);

    }
}
