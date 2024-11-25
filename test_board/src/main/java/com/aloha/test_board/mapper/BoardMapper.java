package com.aloha.test_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.test_board.dto.Board;

@Mapper
public interface BoardMapper {
    
    public List<Board> list() throws Exception;

    public Board select(@Param("no") int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;

    public int delete(int no) throws Exception;
}