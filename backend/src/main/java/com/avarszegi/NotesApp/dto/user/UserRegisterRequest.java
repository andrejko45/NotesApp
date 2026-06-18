package com.avarszegi.NotesApp.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(@NotBlank(message = ERR_MSG_NAME) String name,@NotBlank(message = ERR_MSG_PASSWD) @Size(min = 8, message = ERR_PASSWD_LENGTH) String password) {

    // Validácia mena a hesla prebiehe v DTO zázname
    private static final String ERR_MSG_NAME = "Name can't be empty !";
    private static final String ERR_MSG_PASSWD = "Password can't be empty !";
    private static final String ERR_PASSWD_LENGTH = "Password must have at least 8 characters !";

}
