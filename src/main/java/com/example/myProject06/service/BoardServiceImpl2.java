package com.example.myProject06.service;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.entity.Board;
import com.example.myProject06.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // 비지니스 로직 역할을 처리하는 역할을 중시
@RequiredArgsConstructor
@Primary
public class BoardServiceImpl2 implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public int register(BoardDTO boardDTO) {
        System.out.println("DTO정상 변환 확인. boardDTO = " + boardDTO);
        Board entity = dtoToEntity(boardDTO); // 컨트롤러에서 전달받은 dto를 엔티티로 변환
        boardRepository.save(entity); // 리파지토리에 엔티티를 전달하여 저장
        return entity.getNo(); // 새로 등록된 게시물의 번호를 반환
    }

    @Override
    public BoardDTO read(int no) {
        Optional<Board> byId = boardRepository.findById(no);
        if (byId.isPresent()){
            Board board = byId.get();
            return entityToDto(board);
        }else {
            return null;
        }
    }

    @Override
    public List<BoardDTO> getList() {
        List<Board> result = boardRepository.findAll();
        List<BoardDTO> list = new ArrayList<>();

        list = result.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> byId = boardRepository.findById(boardDTO.getNo()); // entity를 하나 조회하여 꺼내옴
        if (byId.isPresent()){
            Board entity = byId.get(); // 엔티티 변환이 필요없음. 엔티티를 꺼내왔기때문
            entity.setTitle(boardDTO.getTitle());
            entity.setContent(boardDTO.getContent());
            boardRepository.save(entity);
        }
    }


    @Override
    public Board dtoToEntity(BoardDTO boardDTO) {
        return BoardService.super.dtoToEntity(boardDTO);
        //default 메서드 구현에서  default 메서드를 호출해서 구현. (재귀함수 -> 빌더가 return 되면 끝남.)
    }
}
