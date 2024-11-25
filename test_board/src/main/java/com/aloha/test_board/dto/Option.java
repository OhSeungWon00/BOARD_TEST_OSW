package com.aloha.test_board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option {
    String keyword;            
    int code;                
    int orderCode;             

    public Option() {
        this.keyword = "";
    }
}   
