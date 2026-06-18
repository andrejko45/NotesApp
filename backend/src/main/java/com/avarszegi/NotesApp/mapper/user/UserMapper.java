package com.avarszegi.NotesApp.mapper.user;

import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;
import com.avarszegi.NotesApp.entity.user.UserEntity;

public interface UserMapper {

    UserEntity toEntity(UserRegisterRequest request);

    UserRegisterResponse toResponse(UserEntity user);

}
