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
    void test() throws Exception{
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
        Assertions.assertThat(content.size()).isEqualTo(5);
    }
}