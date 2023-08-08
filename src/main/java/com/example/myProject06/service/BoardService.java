package com.example.myProject06.service;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.entity.Board;
import com.example.myProject06.entity.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BoardService {
    
    //게시물 등록
    int register(BoardDTO boardDTO);

    BoardDTO read(int no);

    Page<BoardDTO> getList(int pageNumber);

    void modify(BoardDTO boardDTO);

    void remove(int no);

    //dto 엔티티를 변환하는 메서드
    default Board dtoToEntity(BoardDTO boardDTO){
        Member member = Member.builder().id(boardDTO.getWriter()).build();

        Board entity = Board.builder()
                .no(boardDTO.getNo())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(member)
                .build();

        return entity;
    }

    // 엔티티를 dto로 변환하는 메소드
    default BoardDTO entityToDto(Board entity) {
        BoardDTO dto = BoardDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter().getId())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

}
