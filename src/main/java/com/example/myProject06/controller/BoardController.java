package com.example.myProject06.controller;

import com.example.myProject06.dto.BoardDTO;
import com.example.myProject06.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //메인화면
    @GetMapping("/main")
    public void main(){
        System.out.println("main");
    }

    @GetMapping("/list")
    public void list(Model model){
        List<BoardDTO> list = boardService.getList();
        model.addAttribute("list", list);
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
    public void read(int no, Model model){
        BoardDTO readDTO = boardService.read(no);
        model.addAttribute("dto", readDTO);
    }

    @GetMapping("/modify")
    public void modify(int no, Model model){
        BoardDTO boardDTO = boardService.read(no);
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
