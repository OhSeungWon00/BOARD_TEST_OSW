package com.aloha.test_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.test_board.dto.Board;
import com.aloha.test_board.dto.Option;
import com.aloha.test_board.dto.Page;
import com.aloha.test_board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 게시글 목록
    @Override
    public List<Board> list() throws Exception {
        List<Board> list = boardMapper.list(new Option(), new Page());
        return list;
    }

    // 게시글 조회
    @Override
    public Board select(int no) throws Exception {
        Board board = boardMapper.select(no);
        return board;
    }

    // 게시글 등록
    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);
        return result;
    }

    // 게시글 수정
    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);
        return result;
    }

    // 게시글 삭제
    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);
        return result;
    }


    @Override
    public int count(Option option) throws Exception {
        return boardMapper.count(option);
    }

    @Override
    public List<Board> list(Option option, Page page) throws Exception {
        // 데이터 개수 
        int total = count(option);
        page.setTotal(total);
        
        List<Board> boardList = boardMapper.list(option, page);

        return boardList;
    }

}
