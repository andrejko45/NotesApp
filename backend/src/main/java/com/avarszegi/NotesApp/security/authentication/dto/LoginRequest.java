package com.avarszegi.NotesApp.security.authentication.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank(message = ERR_MSG_BLANK) String name,@NotBlank(message = ERR_MSG_BLANK) String password) {

    private static final String ERR_MSG_BLANK = "Name and password can't be empty !";

}
