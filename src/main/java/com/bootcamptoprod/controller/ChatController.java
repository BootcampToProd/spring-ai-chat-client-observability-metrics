package com.bootcamptoprod.controller;

import com.bootcamptoprod.dto.ChatRequest;
import com.bootcamptoprod.dto.ChatResponse;
import com.bootcamptoprod.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * Handle customer support chat requests
     * Each request triggers complete observability pipeline
     */
    @PostMapping("/message")
    public ResponseEntity<ChatResponse> sendMessage(@RequestBody ChatRequest chatRequest) {
        System.out.println("📞 Incoming customer support request");

        // Process the message through our service
        ChatResponse chatResponse = chatService.processMessage(chatRequest);

        System.out.println("📋 Support response delivered");
        return ResponseEntity.ok(chatResponse);
    }
}
