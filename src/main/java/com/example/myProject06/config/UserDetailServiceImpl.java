package com.example.myProject06.config;

import com.example.myProject06.dto.CustomUser;
import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberService memberService;

    @Override //loadUserByUsername(): 로그인 페이지에서 submit 하는 순간 호출되는 메서드
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO user = memberService.read(username);

        if (user == null){
            throw new UsernameNotFoundException("notFound : "+ username);
        }

        return new CustomUser(user); //custom user 는 userDetails 를 구현하고 있음.
        //시큐리티 컨테이너로 return
    }
}
