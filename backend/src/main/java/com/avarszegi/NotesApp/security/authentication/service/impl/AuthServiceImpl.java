package com.avarszegi.NotesApp.security.authentication.service.impl;

import com.avarszegi.NotesApp.entity.user.UserEntity;
import com.avarszegi.NotesApp.exceptions.ErrorResponseException;
import com.avarszegi.NotesApp.repository.user.UserRepository;
import com.avarszegi.NotesApp.security.authentication.dto.LoginRequest;
import com.avarszegi.NotesApp.security.authentication.dto.LoginResponse;
import com.avarszegi.NotesApp.security.authentication.service.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Override
    public LoginResponse authLogin(LoginRequest request) {

        Optional<UserEntity> user = userRepository.findByName(request.name());

        if(user.isEmpty()) {
            throw new ErrorResponseException("Invalid username or password !");
        }

        if(BCrypt.checkpw(request.password(), user.get().getPasswdH())) {

            Date dateExp = new Date(System.currentTimeMillis() + 3600 * 1000);
            // Generate token
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
            String jws = Jwts.builder().subject(request.name()).expiration(dateExp).signWith(key).compact();
            return new LoginResponse(user.get().getId(), jws, dateExp.getTime());
        }
        else {
            throw new ErrorResponseException("Invalid username or password !");
        }
    }




}
