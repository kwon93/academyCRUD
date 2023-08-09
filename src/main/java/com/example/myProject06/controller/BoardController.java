package com.example.myProject06.controller;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    //메인화면


    @GetMapping("/list")
    public void list(@RequestParam(defaultValue = "0") int page, Model model){
        Page<BoardDTO> pageNum = boardService.getList(page);
        model.addAttribute("list", pageNum);
        log.info("전체 페이지 수 : {}",pageNum.getTotalPages());
        log.info("전체 게시물 수 : {}",pageNum.getTotalElements());
        log.info("현재 페이지 번호 : {}",pageNum.getNumber() + 1);
        log.info("페이지에 표시할 게시물 수  : {}",pageNum.getNumberOfElements());
    }

    @GetMapping("/register")
    public void register(){
        System.out.println("Get - 등록");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        int no = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("msg", no);

        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public void read(int no, Model model, @RequestParam(defaultValue = "0")int page){
        BoardDTO readDTO = boardService.read(no);
        model.addAttribute("page",page);
        model.addAttribute("dto", readDTO);
    }

    @GetMapping("/modify")
    public void modify(int no, Model model, @RequestParam(defaultValue = "0") int page){
        BoardDTO boardDTO = boardService.read(no);
        model.addAttribute("page",page);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modifyPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        boardService.modify(boardDTO);
        redirectAttributes.addAttribute("no",boardDTO.getNo()); // 리다이렉트시 별도의 파라미터가 필요할때.
        return "redirect:/board/read";

    }

    @PostMapping("/remove")
    public String remove(int no){
        boardService.remove(no);
        return "redirect:/board/list";
    }

}
