# Claude Java Client

This Java library provides a simplified and efficient client for interacting with the Anthropic Claude API through AWS Bedrock, allowing seamless access to Claude's features directly from Java applications.

## Features

- **Easy-to-Use Interface**: Simplifies making API requests to the Claude API.
- **AWS Integration**: Utilizes AWS infrastructure for secure and scalable requests.
- **Configuration Management**: Simplifies the configuration of AWS credentials and settings.
- **Enhanced Response Handling**: Provides robust parsing and handling of complex API responses.

## Prerequisites

Before you start, ensure you have the following:
- Java 8 or later.
- An AWS account with access to AWS Bedrock services.
- AWS CLI installed and configured (optional, for ease of setup).

## Installation

To integrate the Claude Java Client into your project, add the following dependency to your Maven `pom.xml`:

```xml
<dependency>
    <groupId>com.github.yoazmenda</groupId>
    <artifactId>claude-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Configuration
AWS Credentials
Ensure that your AWS credentials are configured properly. This can be done in several ways:

By configuring the AWS CLI.
By setting environment variables (AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY, and optionally, AWS_SESSION_TOKEN).
By creating a credentials file at ~/.aws/credentials.

## Usage
Here is a simple example of how to use the Claude Java Client to make a request:
```java
public class Main {
    public static void main(String[] args) {
        ClaudeClient client = new AwsClaudeClient("model-id"); // Replace 'model-id' with your model's ID
        ClaudeRequest request = new ClaudeRequest("Hello, Claude!", 150);
        ClaudeResponse response = client.sendMessage(request);
        System.out.println("Response from Claude: " + response.getText());
        client.close();
    }
}
```