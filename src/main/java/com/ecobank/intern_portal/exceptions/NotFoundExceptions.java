package com.ecobank.intern_portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends RuntimeException {
//    This code handles exceptions
    public NotFoundExceptions(String message) {
        super(message);
    }
}
