package com.avarszegi.NotesApp.security.jwt;

import java.util.Date;

public interface JwtService {

    String generateToken(String name, Date expiresIn);

}
