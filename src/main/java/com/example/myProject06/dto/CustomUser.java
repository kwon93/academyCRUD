package com.example.myProject06.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.List;

public class CustomUser extends User {
    
    //인증 객체
    public CustomUser(MemberDTO memberDTO) {
        super(memberDTO.getId(),
                memberDTO.getPassword(),
                List.of(new SimpleGrantedAuthority(memberDTO.getRole())));
    }

}
