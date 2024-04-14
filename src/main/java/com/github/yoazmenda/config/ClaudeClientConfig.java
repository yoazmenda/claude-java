package com.github.yoazmenda.config;

public class ClaudeClientConfig {
    private static String apiKey;

    public static String getApiKey() {
        return apiKey;
    }

    public static void setApiKey(String newApiKey) {
        apiKey = newApiKey;
    }
}
