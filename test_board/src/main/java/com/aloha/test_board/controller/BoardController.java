package com.aloha.test_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.test_board.dto.Board;
import com.aloha.test_board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 목록
     * 
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    /**
     * 조회
     * 
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/read")
    public String select(Model model, @RequestParam("no") int no) throws Exception {

        // 게시글 조회
        Board board = boardService.select(no);
        model.addAttribute("board", board);

        return "/board/read";
    }

    /**
     * 등록
     * 
     * @return
     */
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }

    /**
     * 등록 처리
     * 
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public String insertPost(Board board) throws Exception {
        int result = boardService.insert(board);
        if (result > 0) {
            return "redirect:/board/list";
        }

        return "redirect:/board/insert?error";
    }

    /**
     * 수정
     * 
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("update")
    public String update(Model model, @RequestParam("no") int no) throws Exception {

        Board board = boardService.select(no);
        model.addAttribute("board", board);

        return "/board/update";
    }

    /**
     * 수정 처리
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping("update")
    public String updatePost(Board board) throws Exception {
        int result = boardService.update(board);
        if (result > 0) {
            
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error&no="+board.getNo();
    }


   // 삭제 처리
   @PostMapping("/delete")
   public String delete(@RequestParam("no") int no) throws Exception {
       int result = boardService.delete(no);
       if( result > 0 ) 
           return "redirect:/board/list";
       return "redirect:/board/update?error&no="+no;
   }
        
    }
    




