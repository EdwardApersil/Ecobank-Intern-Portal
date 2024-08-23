package com.ecobank.intern_portal.errorResponse;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class TaskErrorResponse extends ErrorResponse{
    public TaskErrorResponse(int status, String message, String error, String timestamp, String path) {
        super(status, message, error, timestamp, Long.valueOf(path));
    }

    public TaskErrorResponse(int value, String taskNotFound, String error, long l, String requestURI) {
        super();
    }
}
