package com.example.myProject06.repository;

import com.example.myProject06.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 등록하기")
    void test1() throws Exception{
        //given
        Member userA = Member.builder()
                .id("userA")
                .password("1234")
                .name("kim")
                .build();

        Member userB = Member.builder()
                .id("userB")
                .password("1234")
                .name("lee")
                .build();

        //when
        Member savedMember = memberRepository.save(userA);
        Member savedMember2 = memberRepository.save(userB);

        //then
        assertThat(savedMember.getId()).isEqualTo(userA.getId());
    }

    @Test
    @DisplayName("회원 단건 조회하기")
    void test2() throws Exception{
        //given
        memberRepository.findById("userA").ifPresent(member -> log.info("조회된 1번 회원의 이름은 {} 입니다.",member.getName()));
        //when

        //then
    }

    @Test
    @DisplayName("회원 전부 조회하기")
    void test3() throws Exception{
        //given
        List<Member> members = memberRepository.findAll();
        //when

        //then
        assertThat(members.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("userB 회원 이름 수정하기")
    void test4() throws Exception{
        //given
        final String id = "park";
        memberRepository.findById("userB").ifPresent(member -> {
            member.setName(id);
            memberRepository.save(member);
        });
        //when
        @SuppressWarnings("all ")
        Member updatedMember = memberRepository.findById("userB").get();
        //then
        assertThat(updatedMember.getName()).isEqualTo(id);
    }

    @Test
    @DisplayName("회원 삭제하기")
    void test5() throws Exception{
        //given
        final String id = "userB";

        //when
        memberRepository.deleteById(id);
        //then
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(1);
    }
}