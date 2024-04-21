package com.github.yoazmenda.client;

import com.github.yoazmenda.model.ClaudeRequest;
import com.github.yoazmenda.model.ClaudeResponse;

public interface ClaudeClient {
    ClaudeResponse sendMessage(ClaudeRequest request) throws Exception;
}