package com.github.yoazmenda.client;

import com.github.yoazmenda.model.ClaudeRequest;
import com.github.yoazmenda.model.ClaudeResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Collectors;
import org.mockito.Mockito;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;

public class AwsClaudeClientTest {
    private AwsClaudeClient client;
    private BedrockRuntimeClient mockBedrockClient;

    @BeforeEach
    public void setUp() {
        mockBedrockClient = Mockito.mock(BedrockRuntimeClient.class);
        client = new AwsClaudeClient(mockBedrockClient, "anthropic.claude-3-5-haiku-20241022-v1:0");
    }

    @AfterEach
    public void tearDown() {
        client.close();
    }

    @Test
    public void testSendMessage() throws Exception {
        // Simulate the response
        SdkBytes responseBody = SdkBytes.fromUtf8String("{\"content\":[{\"type\":\"text\",\"text\":\"Mocked response\"}]}");
        InvokeModelResponse mockResponse = InvokeModelResponse.builder().body(responseBody).build();
        Mockito.when(mockBedrockClient.invokeModel(Mockito.any(InvokeModelRequest.class))).thenReturn(mockResponse);

        // Test the sendMessage method
        ClaudeRequest request = new ClaudeRequest("Hello, Claude!", 150);
        ClaudeResponse response = client.sendMessage(request);
        assertNotNull(response);
        assertNotNull(response.getContent());
        assertFalse(response.getContent().isEmpty());
        String responseText = response.getContent().stream()
                .map(ClaudeResponse.Content::getText)
                .collect(Collectors.joining(" "));
        assertEquals("Mocked response", responseText);
        System.out.println("Response: " + responseText);
    }
} 