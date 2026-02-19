package org.sparta;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OpenAiTest {

    @Autowired
    private ChatModel chatModel;

    @Test
    void testOpenAiCall() {
        String message = "안녕, 너는 누구니?";
        String response = chatModel.call(message);
        
        System.out.println("================ OpenAI Response ================");
        System.out.println(response);
        System.out.println("=================================================");
        
        assertThat(response).isNotEmpty();
    }
}
