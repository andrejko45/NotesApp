package com.avarszegi.NotesApp.mapper.user.impl;

import com.avarszegi.NotesApp.dto.user.UserRegisterRequest;
import com.avarszegi.NotesApp.dto.user.UserRegisterResponse;
import com.avarszegi.NotesApp.entity.user.UserEntity;
import com.avarszegi.NotesApp.mapper.user.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    // Hashovane heslo a createdAt sa rieši v Service vrstve
    @Override
    public UserEntity toEntity(UserRegisterRequest request) {
        return new UserEntity(null, request.name(), request.password(), null, null);
    }


    // Vraciame len id, meno a dátum vytvorenia
    @Override
    public UserRegisterResponse toResponse(UserEntity user) {
        return new UserRegisterResponse(user.getId(), user.getName(), user.getCreatedAt());
    }

}
