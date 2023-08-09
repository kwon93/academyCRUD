package com.example.myProject06.service;

import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.entity.Member;
import com.example.myProject06.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceImplTest {


    @Autowired
    MemberServiceImpl memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 목록 조회하기")
    void test1() throws Exception{
        //given
        for (int i = 0; i < 30; i++) {
        memberRepository.save(Member.builder()
                .id("userNo."+i)
                .name("kim")
                .password("1234")
                .build());
        }
        //when
        Page<MemberDTO> list = memberService.getList(1);
        List<MemberDTO> content = list.getContent();
        for (MemberDTO memberDTO : content) {
            log.info("조회된 회원 목록입니다. : {}",memberDTO);
        }
        //then
        assertThat(content.size()).isEqualTo(5);
    }
    
    @Test
    @DisplayName("회원등록하기")
    void test2() throws Exception{
        //given
        final String userId = "userA";
        MemberDTO userA = MemberDTO.builder()
                .id(userId)
                .name("kim")
                .password("1234")
                .build();

        //when
        memberService.register(userA);

        Member member = memberRepository.findById(userId).get();
        //then
        assertThat(member.getId()).isEqualTo(userId);
    }

    @Test
    @DisplayName("중복 아이디일시에 false값이 return되어야하고 저장되지 말아야함.")
    void test3() throws Exception{
        //given
        final String userId = "userA";
        final String userName = "falseUser";
        MemberDTO userA = MemberDTO.builder()
                .id(userId)
                .name(userName)
                .password("1234")
                .build();
        //when
        boolean isNotDuplicate = memberService.register(userA);
        Member member = memberRepository.findById(userId).get();
        //then
        assertThat(isNotDuplicate).isFalse();
        assertThat(member.getName()).isNotEqualTo(userName);

    }
    
    @Test
    @DisplayName("read() : 회원 단건 조회에 성공하기")
    void test4() throws Exception{
        //given
        String userA = "userA";
        //when
        MemberDTO readMember = memberService.read(userA);
        log.info("회원 단건 조회 결과는 : {}", readMember);

        //then
        assertThat(readMember.getId()).isEqualTo(userA);
    }

}