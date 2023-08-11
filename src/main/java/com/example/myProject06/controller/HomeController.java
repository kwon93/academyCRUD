package com.example.myProject06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String main(Principal principal, Model model){
        model.addAttribute("id",principal.getName());
        return "/home/main";
    }

    @GetMapping("/customlogin")
    public String customLogin(){
        return "home/login";
    }

}
