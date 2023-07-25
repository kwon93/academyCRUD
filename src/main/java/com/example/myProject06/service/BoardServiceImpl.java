package com.example.myProject06.service;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.entity.Board;
import com.example.myProject06.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 비지니스 로직 역할을 처리하는 역할을 중시
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService {

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
        return null;
    }

    @Override
    public List<BoardDTO> getList() {
        return null;
    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

    @Override
    public Board dtoToEntity(BoardDTO boardDTO) {
        return BoardService.super.dtoToEntity(boardDTO);
        //defualt메서드 구현에서  defualt 메서드를 호출해서 구현. (재귀함수 -> 빌더가 return되면 끝남.)
    }
}
