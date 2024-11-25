package com.aloha.test_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.test_board.dto.Board;
import com.aloha.test_board.dto.Option;
import com.aloha.test_board.dto.Page;

@Mapper
public interface BoardMapper {

    public List<Board> list(@Param("option") Option option, @Param("page") Page page) throws Exception;

    public Board select(@Param("no") int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;

    public int delete(int no) throws Exception;

    // 데이터 개수
    public int count(@Param("option") Option option) throws Exception;
}