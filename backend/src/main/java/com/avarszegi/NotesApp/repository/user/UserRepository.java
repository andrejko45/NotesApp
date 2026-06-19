package com.avarszegi.NotesApp.repository.user;

import com.avarszegi.NotesApp.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    public Optional<UserEntity> findByName(String name);        // Query na nájdenie používateľa podľa mena
                                                                // SELECT ... FROM USERS WHERE name = request.name()
}
