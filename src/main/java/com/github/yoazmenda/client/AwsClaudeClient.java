package com.github.yoazmenda.client;

import com.github.yoazmenda.model.ClaudeRequest;
import com.github.yoazmenda.model.ClaudeResponse;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

public class AwsClaudeClient implements ClaudeClient {
    private final BedrockRuntimeClient bedrockClient;
    private final String modelId;

    public AwsClaudeClient(String modelId) {
        this.bedrockClient = BedrockRuntimeClient
                .builder()
                .region(Region.US_EAST_1)
                .build();
        this.modelId = modelId;
    }

    @Override
    public ClaudeResponse sendMessage(ClaudeRequest request) throws Exception {
        InvokeModelRequest awsRequest = InvokeModelRequest.builder()
                .modelId(modelId)
                .contentType("application/json")
                .body(SdkBytes.fromByteArray(request.toJsonAsBytes()))
                .build();

        InvokeModelResponse awsResponse = bedrockClient.invokeModel(awsRequest);
        // Convert SdkBytes to String
        return ClaudeResponse.fromJson(awsResponse.body().asUtf8String());
    }

    public void close() {
        bedrockClient.close();
    }
}
