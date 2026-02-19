package org.sparta.aistudy.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.core.Ordered;

@Slf4j
public class Advisor1 implements CallAdvisor {

    @Override
    public String getName() {
        return getClass().getSimpleName(); // 이름지정
    }

    @Override
    public int getOrder() { //어드바이저 적용 순서 작을수록 먼저 동작.
        return Ordered.HIGHEST_PRECEDENCE+1;
    }

    @Override  //ChatClientRequest 프롬포트 정보 담겨있음.
    public ChatClientResponse adviseCall(ChatClientRequest request, CallAdvisorChain chain) {
        // 전처리
        log.info("[Advisor1] - 전처리"); //프롬프트 증강, 필터링
        ChatClientResponse response = chain.nextCall(request);

        // 후처리
        log.info("[Advisor1] - 후처리"); // 대화내용 저장, 응답 필터링
        return response;
    }

}
