package com.github.yoazmenda;

import com.github.yoazmenda.config.ClaudeClientConfig;
import com.github.yoazmenda.model.CLaudeResponse;
import com.github.yoazmenda.utils.HttpRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ClaudeClient {
    private ObjectMapper objectMapper;

    public ClaudeClient() {
        this.objectMapper = new ObjectMapper();
    }

    public CLaudeResponse sendRequest(String endpoint) {
        String apiKey = ClaudeClientConfig.getApiKey();
        try {
            String responseJson = HttpRequestUtil.sendGetRequest(endpoint, apiKey);
            CLaudeResponse response = objectMapper.readValue(responseJson, CLaudeResponse.class);
            return response;
        } catch (IOException e) {
            return new CLaudeResponse("error", "Failed to send request: " + e.getMessage());
        }
    }
}
