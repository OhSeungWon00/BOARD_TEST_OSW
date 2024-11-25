package com.aloha.test_board.service;

import java.util.List;

import com.aloha.test_board.dto.Board;
import com.aloha.test_board.dto.Option;
import com.aloha.test_board.dto.Page;

public interface BoardService {


    public List<Board> list(Option option, Page page) throws Exception;

    public List<Board> list() throws Exception;

    public Board select(int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;

    public int delete(int no) throws Exception;


    public int count(Option option) throws Exception;

}
