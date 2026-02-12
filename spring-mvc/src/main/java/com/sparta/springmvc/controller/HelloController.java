package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello") // 단순조회
    @ResponseBody// json 객체나 텍스트 반환할때 씀
    public String hello() {
        return "hello World!!!!";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "get 메서드 요청";
    }

    @PostMapping("/post")// 인서트
    @ResponseBody
    public String post() {
        return "post 메서드 요청";
    }

    @PutMapping("/put") //업데이트
    @ResponseBody
    public String put() {
        return "put 메서드 요청";
    }

    @DeleteMapping("/delete") // 삭제
    @ResponseBody
    public String delete() {
        return "delete 메서드 요청";
    }
}
