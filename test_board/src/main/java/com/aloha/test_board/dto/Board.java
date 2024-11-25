package com.aloha.test_board.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Alias("Board")
public class Board {

    private int no;
    private String title;
    private String writer;
    private String content;
    private Date createdAt;
    private Date updatedAt;

}
