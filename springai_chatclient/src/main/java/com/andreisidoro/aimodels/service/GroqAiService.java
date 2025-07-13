package com.andreisidoro.aimodels.service;

import org.springframework.stereotype.Service;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.client.ChatClient;

@Service
public class GroqAiService {

    private final ChatClient chatClient;

    public GroqAiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String message) {
        return this.chatClient.prompt()
            .user(message)
            .call()
            .content();
    }
}