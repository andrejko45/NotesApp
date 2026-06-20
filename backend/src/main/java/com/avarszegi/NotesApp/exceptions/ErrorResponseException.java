package com.avarszegi.NotesApp.exceptions;

public class ErrorResponseException extends RuntimeException {
    public ErrorResponseException(String message) {
        super(message);
    }
}
