package com.avarszegi.NotesApp.exceptions;

import com.avarszegi.NotesApp.dto.ValidationErrorResponse;
import com.avarszegi.NotesApp.dto.user.UserAlreadyExists;
import com.avarszegi.NotesApp.exceptions.user.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

// Globálne spracovanie výnimiek                                                                                            Odpoveď HTTP má byť 400
                                                                                                                        // čo značí chybu na strane klienta
@RestControllerAdvice                                                                                                   // Zachytanie validačných chýb typu @NotNull, @NotBlank, @Email ..
public class GlobalExceptionHandler {                                                                                   // Premenna e obsahuje všetky validačné chyby
                                                                                                                        // Vracia DTO ValidationErrorResponse
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse validationErrorResponse(MethodArgumentNotValidException e) {

        List<String> validErrorsList = new ArrayList<>();
        List<FieldError> validFieldErrors = e.getBindingResult().getFieldErrors();

        for(FieldError f : validFieldErrors) {
            validErrorsList.add(f.getDefaultMessage());
        }

        return new ValidationErrorResponse("Validation failed !", validErrorsList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)                                                                             // Vlastná výnimka ak používateľ
    @ExceptionHandler(UserAlreadyExistsException.class)                                                                 // s týmto menom už existuje
    public UserAlreadyExists userAlreadyExists(UserAlreadyExistsException e) {
        return new UserAlreadyExists(e.getMessage());
    }



}
