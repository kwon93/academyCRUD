//package com.example.myProject06.board;
//
//import com.example.myProject06.dto.BoardDTO;
//import com.example.myProject06.entity.Board;
//import com.example.myProject06.repository.BoardRepository;
//import com.example.myProject06.service.BoardService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class BoardRepositoryTest {
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Autowired
//    BoardService boardService;
//
//    @Test
//    @DisplayName("글 등록하기")
//    void quiz1(){
////        Board board = new Board(1, "1번글", "둘리", "가나다");
////        Board board2 = new Board(2, "2번글", "또치", "라마바사");
//        Board build = Board.builder()
//                .title("4번글")
//                .content("4번글입니다~~~")
//                .writer("고길동")
//                .build();
////        boardRepository.save(board);
////        boardRepository.save(board2);
//        boardRepository.save(build);
//    }
//
//    @Test
//    @DisplayName("단건 조회하기")
//    void quiz2(){
//        Optional<Board> byId = boardRepository.findById(1);
//        System.out.println(byId);
//    }
//
//    @Test
//    @DisplayName("전체 조회하기")
//    void quiz5(){
//        List<Board> all = boardRepository.findAll();
//        for (Board board : all) {
//            System.out.println(board);
//        }
//    }
//
//    @Test
//    @DisplayName("글 수정하기")
//    void quiz3(){
//        Optional<Board> byId = boardRepository.findById(3);
//        Board board = byId.get();
//        board.setContent("수정된 컨텐츠입니다.");
//        boardRepository.save(board);
//    }
//
//    @Test
//    @DisplayName("글 삭제하기")
//    void quiz4(){
//        Optional<Board> byId = boardRepository.findById(2);
//        if(byId.isPresent()){ //아이디가 존재한다면 삭제하는 조건문.
//            Board board = byId.get();
//            boardRepository.delete(board);
//        }
//    }
//
//    @Test
//    @DisplayName("DTO가 Entity로 변환되는지 확인")
//    void quiz6(){
//        BoardDTO build = BoardDTO.builder()
//                .title("타이틀1123123")
//                .content("dto컨텐츠~~~~~~")
//                .writer("도우너")
//                .build();
//        int no = boardService.register(build);
//        System.out.println("새로운 번호"+no);
//    }
//
////    @Test
////    @DisplayName("Entity 를 DTO로 변환해 조회하기")
////    void quiz7(){
////        List<BoardDTO> list = boardService.getList();
////        for (BoardDTO boardDTO : list) {
////            System.out.println(boardDTO);
////        }
//
//
//        List<String> collect = list.stream()
//                .map(BoardDTO::getTitle)
//                .collect(Collectors.toList());
//    }
//
//    @Test
//    @DisplayName("상세조회 기능이 정상 동작하는지 테스트")
//    void quiz8(){
//        //정상적인 글번호 동작 테스트
//        BoardDTO read = boardService.read(3);
//        assertThat(read.getTitle()).isEqualTo("1번글");
//
//        //null을 return하는지 테스트
//        BoardDTO read2 = boardService.read(1);
//        assertThat(read2).isSameAs(null);
//    }
//
//    @Test
//    @DisplayName("게시물 수정이 정상적으로 동작하는지 확인")
//    void quiz9(){
//        BoardDTO read = boardService.read(3);
//        read.setContent("test");
//        boardService.modify(read);
//
//        BoardDTO mod1 = BoardDTO.builder()
//                .no(3)
//                .title("3번글")
//                .content("변경됨")
//                .writer("고길동")
//                .build();
//        boardService.modify(mod1);
//
//
//    }
//
//    @Test
//    @DisplayName("삭제기능 정상 동작 확인하기")
//    void quiz10(){
//        boardService.remove(5);
//    }
//
//}
