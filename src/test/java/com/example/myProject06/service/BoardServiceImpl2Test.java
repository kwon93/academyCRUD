package com.example.myProject06.service;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.entity.Board;
import com.example.myProject06.entity.Member;
import com.example.myProject06.repository.BoardRepository;
import com.example.myProject06.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImpl2Test {


    @Autowired
    BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;


//    @Test
//    @DisplayName("글 30개 등록하기")
//    void test1() throws Exception{
//        //given
//        for (int i = 0; i < 30 ; i++) {
//            Board board = new Board(0, i + "번째 게시물", "안녕하세요.", "둘리");
//            boardRepository.save(board);
//        }
//        //when
//        //then
//    }
//
//    @Test
//    @DisplayName("게시물 조회하기")
//    void test2() throws Exception{
//        //given
//        Page<BoardDTO> list = boardService.getList(2);
//        List<BoardDTO> content = list.getContent();
//        //when
//        for (BoardDTO boardDTO : content) {
//            System.out.println(boardDTO);
//        }
//        //then
//    }

    @Test
    @DisplayName("게시물 등록 성공하기.")
    void test() throws Exception{
        //given
        Member userA = Member.builder().id("userA").name("kim").password("1234").build();
        memberRepository.save(userA);
        Board board1 = Board.builder()
                .title("안녕하세요")
                .content("내용 작성 칸입니다.")
                .writer(userA)
                .build();

        //when
        Board save = boardRepository.save(board1);

        //then
//        Assertions.assertThat(save.getWriter().getId()).isEqualTo("userA");
    }


    @Test
    @DisplayName("특정 회원만 삭제하기")
    void test6() throws Exception{
        //given
        Member member = Member.builder().id("userA").build();
        //when
        boardRepository.deleteWriter(member);
        memberRepository.deleteById("userA");
        //then
    }
}