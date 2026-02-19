package org.sparta.aistudy.presentation;

import org.sparta.aistudy.application.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@Controller
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private  ChatbotService chatbotService;

    @GetMapping
    public String index(){
        return "chatbot/index";
    }

    @ResponseBody
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
            //newline delimited json {_,_,_}
    )
    public String message(@RequestBody String question){
        return chatbotService.chat(question);
    }
}
