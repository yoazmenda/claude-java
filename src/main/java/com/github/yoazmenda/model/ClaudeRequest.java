package com.github.yoazmenda.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ClaudeRequest {
    private final String prompt;
    private final int maxTokens;

    public ClaudeRequest(String prompt, int maxTokens) {
        this.prompt = prompt;
        this.maxTokens = maxTokens;
    }

    public byte[] toJsonAsBytes() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> body = Map.of(
                "anthropic_version", "bedrock-2023-05-31",
                "max_tokens", this.maxTokens,
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", List.of(
                                        Map.of(
                                                "type", "text",
                                                "text", this.prompt
                                        )
                                )
                        )
                )
        );
        return mapper.writeValueAsString(body).getBytes(StandardCharsets.UTF_8);
    }
}