package com.sparta.springprepare;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@RequiredArgsConstructor // final 추가
public class Memo {
    private final String username;
    private  String contents;

//private final String contents;
}

class Main {
    public static void main(String[] args) {
        Memo memo = new Memo("db");
        //memo.setUsername("db");
        System.out.println( memo.getUsername());
    }
}
