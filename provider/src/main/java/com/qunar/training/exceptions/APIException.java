package com.qunar.training.exceptions;

/**
 * @author YISHEN CAI
 */
public class APIException extends RuntimeException{
    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }
}
