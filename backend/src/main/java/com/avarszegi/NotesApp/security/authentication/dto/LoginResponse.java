package com.avarszegi.NotesApp.security.authentication.dto;

import java.util.UUID;

public record LoginResponse(UUID userId, String token, Long expiresIn) {
}
