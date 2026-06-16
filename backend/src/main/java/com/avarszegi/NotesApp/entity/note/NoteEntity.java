package com.avarszegi.NotesApp.entity.note;

import com.avarszegi.NotesApp.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


// Relácia ktorá reprezentuje poznámku používateľa

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    // Každá poznámka patrí 1 používatelovi
    // V entite Note bude atribút id_user
    // Nemôže existovať poznámka bez vlastníka

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    private LocalDate createdAt;


}
