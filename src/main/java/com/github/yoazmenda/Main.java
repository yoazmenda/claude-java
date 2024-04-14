package com.github.yoazmenda;

import com.github.yoazmenda.config.ClaudeClientConfig;
import com.github.yoazmenda.model.CLaudeResponse;

public class Main {
    public static void main(String[] args) {
        ClaudeClientConfig.setApiKey("your_api_key_here");
        ClaudeClient client = new ClaudeClient();
        CLaudeResponse response = client.sendRequest("https://api.anthropic.com/your-endpoint");
        System.out.println("Status: " + response.getStatus());
        System.out.println("Data: " + response.getData());
    }
}
