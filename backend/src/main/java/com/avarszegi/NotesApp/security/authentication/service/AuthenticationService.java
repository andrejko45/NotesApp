package com.avarszegi.NotesApp.security.authentication.service;

import com.avarszegi.NotesApp.security.authentication.dto.LoginRequest;
import com.avarszegi.NotesApp.security.authentication.dto.LoginResponse;


public interface AuthenticationService {

    LoginResponse authLogin(LoginRequest request);


}
