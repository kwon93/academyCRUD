package com.example.myProject06.controller;

import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/member/list")
    public void list(@RequestParam(defaultValue = "0")int page, Model model){
        Page<MemberDTO> list = memberService.getList(page);
        List<MemberDTO> content = list.getContent();
        model.addAttribute("list",list);

    }

    @GetMapping("/register")
    public String  register(){
        return "/member/register";
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO, Model model){
        boolean isSuccess = memberService.register(memberDTO);
        if (isSuccess){
            return "redirect:/";
        }else {
            model.addAttribute("msg","중복된 아이디입니다.");
            return "/register";
        }
    }

    @GetMapping("/member/read")
    public void read(String id, @RequestParam(defaultValue = "0") int page, Model model){
        MemberDTO read = memberService.read(id);
        model.addAttribute("dto",read);
        model.addAttribute("page",page);
    }
}
