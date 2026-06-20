package com.avarszegi.NotesApp.security.authentication.service;

import com.avarszegi.NotesApp.security.authentication.dto.LoginRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    UserDetails authenticate(String name, String password);
    String generateToken(LoginRequest loginRequest);

}
