package com.avarszegi.NotesApp.entity.user;

import com.avarszegi.NotesApp.entity.note.NoteEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Relácia reprezentujúca používateľa systému


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String passwdH;

    @NotNull
    @Column(nullable = false)
    private LocalDate createdAt;

    // Vzťah s poznámkami
    // 1 používateľ môže mať viacero poznámok
    // Je mapovaná na strane NoteEntity id(FK) kľúčom používatela

    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;

}
