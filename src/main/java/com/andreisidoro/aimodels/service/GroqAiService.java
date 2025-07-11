package com.andreisidoro.aimodels.service;

import org.springframework.stereotype.Service;
import org.springframework.ai.openai.OpenAiChatModel;


@Service
public class GroqAiService {

    private final OpenAiChatModel groqChatModel;

    public GroqAiService(OpenAiChatModel groqChatModel) {
        this.groqChatModel = groqChatModel;
    }

    public String chat(String message) {
        return groqChatModel.call(message);
    }
}