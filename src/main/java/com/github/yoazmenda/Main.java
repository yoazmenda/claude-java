package com.github.yoazmenda;

import com.github.yoazmenda.client.AwsClaudeClient;
import com.github.yoazmenda.client.ClaudeClient;
import com.github.yoazmenda.model.ClaudeRequest;
import com.github.yoazmenda.model.ClaudeResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        ClaudeClient client = new AwsClaudeClient("anthropic.claude-3-haiku-20240307-v1:0");
        ClaudeRequest request = new ClaudeRequest("Explain black holes to 8th graders", 2048);
        ClaudeResponse response = client.sendMessage(request);
        System.out.println("Response from AWS Claude: " + response.toString());
    }
}