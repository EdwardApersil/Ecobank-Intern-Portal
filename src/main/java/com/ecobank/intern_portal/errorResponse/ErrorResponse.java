package com.ecobank.intern_portal.errorResponse;

public class ErrorResponse {
    private int status;
    private String message;
    private String error;
    private String path;
    private Long timestamp;

    public ErrorResponse(int status, String message, String error, String path, Long timestamp) {
        this.message = message;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
        this.status = status;
    }

    public ErrorResponse() {


    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
