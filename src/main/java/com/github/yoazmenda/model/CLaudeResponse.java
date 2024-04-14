package com.github.yoazmenda.model;

public class CLaudeResponse {
    private String status;
    private String data;

    public CLaudeResponse(String status, String data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
