package com.avarszegi.NotesApp.dto;

import java.util.List;

public record ValidationErrorResponse(String message, List<String> errors) {
}
