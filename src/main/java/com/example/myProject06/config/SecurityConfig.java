package com.example.myProject06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/assets/**", "/css/**", "/js/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/board/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/member/**").hasAnyRole("ADMIN");
        http.formLogin();
        http.csrf().disable();

        http.logout();

        //커스텀 로그인 페이지 적용
        http.formLogin()
                .loginPage("/customlogin")
                .loginProcessingUrl("/login")
                .permitAll();

       return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
