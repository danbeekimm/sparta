package org.sparta.aistudy.application;

import reactor.core.publisher.Flux;

public interface ChatbotService {
    String chat(String question);

}
