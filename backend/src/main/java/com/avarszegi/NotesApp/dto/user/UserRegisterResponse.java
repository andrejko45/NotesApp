package com.avarszegi.NotesApp.dto.user;

import java.time.LocalDate;
import java.util.UUID;

public record UserRegisterResponse(UUID id, String name, LocalDate createdAt) {
}
