package com.bootcamptoprod.service;

import com.bootcamptoprod.dto.ChatRequest;
import com.bootcamptoprod.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final String SYSTEM_PROMPT = getSystemPrompt();

    private final ChatClient chatClient;

    /**
     * Constructor injection for ChatClient
     * ChatClient.Builder is auto-configured by Spring AI
     */
    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Processes user messages through OpenRouter AI models
     */
    public ChatResponse processMessage(ChatRequest chatRequest) {
        System.out.println("🎯 Processing customer support request");

        try {
            // Send the user's message to the AI model via OpenRouter
            String content = chatClient.prompt()
                    .system(SYSTEM_PROMPT)
                    .user(chatRequest.message())  // Set the user's message
                    .call()                       // Make the API call
                    .content();                   // Extract the response content

            System.out.println("✅ Support response generated with full observability");
            return new ChatResponse(content);

        } catch (Exception e) {
            // Log the error for debugging while providing user-friendly response
            System.err.println("❌ Error processing message: " + e.getMessage());
            return new ChatResponse("I apologize for the technical difficulty. Please try again in a moment.");
        }
    }

    private String getSystemPrompt() {
        return """
                You are a helpful customer support assistant.
                
                Your responsibilities:
                - Answer product questions and provide specifications
                - Help troubleshoot technical issues step-by-step
                - Assist with account and billing inquiries
                - Provide clear, concise, and professional responses
                
                If you cannot resolve an issue completely, guide the customer 
                to contact human support with specific next steps.
                """;
    }
}
