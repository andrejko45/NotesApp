package com.avarszegi.NotesApp.service.user.impl;


import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;
import com.avarszegi.NotesApp.entity.user.UserEntity;
import com.avarszegi.NotesApp.mapper.user.UserMapper;
import com.avarszegi.NotesApp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl {



    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserRegisterResponse registerUser(UserRegisterRequest request) {

        logger.trace("Creating user {}", request);                                      // Log o vytváraní používatela
        UserEntity newUser = userMapper.toEntity(request);                              // Vytvor novú entitu a premapuj
                                                                                        // údaje z požiadavky do tejto entity
        newUser.setPasswdH(BCrypt.hashpw(request.password(), BCrypt.gensalt()));        // Zahashuj heslo a ulož ho do entity
        newUser.setCreatedAt(LocalDate.now());                                          // Vygeneruj dátum vytvorenia používateľa
        userRepository.save(newUser);                                                   // Ulož registrovaného používateľa do DB
        return userMapper.toResponse(newUser);                                          // Vráť odpoveď stránke


    }



}
