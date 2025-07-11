package com.andreisidoro.aimodels.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andreisidoro.aimodels.service.GroqAiService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final GroqAiService groqAiService;

    public ChatController(GroqAiService groqAiService) {
        this.groqAiService = groqAiService;
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return groqAiService.chat(message);
    }
}