package com.avarszegi.NotesApp.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(@NotBlank(message = ERR_MSG_NAME) String name,@NotBlank(message = ERR_MSG_PASSWD) String password) {

    // Validácia mena a hesla prebiehe v DTO zázname
    private static final String ERR_MSG_NAME = "Name can't be empty !";
    private static final String ERR_MSG_PASSWD = "Password can't be empty !";

}
