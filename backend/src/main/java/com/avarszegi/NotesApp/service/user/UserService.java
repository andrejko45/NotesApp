package com.avarszegi.NotesApp.service.user;

import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;

public interface UserService {

    UserRegisterResponse registerUser(UserRegisterRequest request);

}
