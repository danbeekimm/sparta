package org.sparta.aistudy.prompt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
public class PromptTemplateTest {

    ChatClient chatClient;

    @BeforeEach
    void init(@Autowired ChatClient.Builder builder){
        chatClient = builder.build();
    }
    @Test
    void test1(){
        String template = "{person}의 명언 3가지 알려줘";
        //PromptTemplate promptTemplate = new PromptTemplate(template);
        PromptTemplate promptTemplate = PromptTemplate.builder()
                .template(template)
                .build(); // userMessage 쓸때
        /*
        * String render(Map<String, Object> ..)
        * Prompt create(Map<String, object> ...)
        * */
        Prompt prompt = promptTemplate.create(Map.of("person", "이순신장군"));
        String promptStr = prompt.getContents();
        log.info("promptStr: {}", promptStr);
    }

    @Test
    void test2(){
        String answer = chatClient.prompt()
                //.user(userSpect -> userSpect.text("{person}의 명언 알려줘").param("person","아이유"))
                .user("%s의 명언 3가지 알려줘".formatted("테일러 스위프트"))
                .call()
                .content();
        log.info("answer: {}", answer);
    }
}
