package com.andreisidoro.aimodels.config;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.andreisidoro.aimodels.advisors.SimpleLoggerAdvisor;

@Configuration
public class AiClientConfig {


    @Bean
    public OpenAiChatModel groqChatModel(
            @Value("${spring.ai.groq.api-key}") String apiKey,
            @Value("${spring.ai.groq.base-url}") String baseUrl
    ) {
        // Create a new API instance for Groq
        OpenAiApi groqApi = OpenAiApi.builder()
                .apiKey(apiKey)
                .baseUrl(baseUrl)
                .build();

        // Create and return the Groq-backed chat model
        return OpenAiChatModel.builder()
                .openAiApi(groqApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("llama-3.1-8b-instant")
                        .temperature(0.5)
                        .build())
                .build();
    }

    @Bean
    public SimpleLoggerAdvisor simpleLoggerAdvisor() {
        return new SimpleLoggerAdvisor();
    }

    @Bean
    public ChatClient chatClient(OpenAiChatModel groqChatModel, SimpleLoggerAdvisor advisor) {
        return ChatClient.builder(groqChatModel)
                .defaultAdvisors(List.of(advisor))
                .build();
    }
}
