package com.avarszegi.NotesApp.service.user.impl;


import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;
import com.avarszegi.NotesApp.entity.user.UserEntity;
import com.avarszegi.NotesApp.exceptions.user.UserAlreadyExistsException;
import com.avarszegi.NotesApp.mapper.user.UserMapper;
import com.avarszegi.NotesApp.repository.user.UserRepository;
import com.avarszegi.NotesApp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest request) {

        Optional<UserEntity> user = userRepository.findByName(request.name());

        if(user.isPresent()) {
            throw new UserAlreadyExistsException("User with name" + request.name() + " already exists ! Please choose another name !");
        }

        logger.trace("Creating user {}", request);                                      // Log o vytváraní používatela
        UserEntity newUser = userMapper.toEntity(request);                              // Vytvor novú entitu a premapuj
                                                                                        // údaje z požiadavky do tejto entity
        newUser.setPasswdH(BCrypt.hashpw(request.password(), BCrypt.gensalt()));        // Zahashuj heslo a ulož ho do entity
        newUser.setCreatedAt(LocalDate.now());                                          // Vygeneruj dátum vytvorenia používateľa
        userRepository.save(newUser);                                                   // Ulož registrovaného používateľa do DB
        return userMapper.toResponse(newUser);                                          // Vráť odpoveď stránke

    }



}
