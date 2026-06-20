package com.avarszegi.NotesApp.controller;

import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;
import com.avarszegi.NotesApp.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/auth/register")
    public UserRegisterResponse userRegister(@Valid @RequestBody UserRegisterRequest request) {
        return userService.registerUser(request);
    }

}
