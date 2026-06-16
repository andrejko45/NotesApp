package com.avarszegi.NotesApp.entity.note;

import com.avarszegi.NotesApp.entity.tag.TagEntity;
import com.avarszegi.NotesApp.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
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

    // V DB bude spojovacia tabuľka s názvom tags_on_notes
    // Časť note_id je v NoteEntity a je prvá časť kompozitného kľúča
    // Časť tag_id je v TagEntity a je druhá časť kompozitnéhp kľúča
    //

    @ManyToMany
            @JoinTable(
                    name = "tags_on_notes",
                    joinColumns = @JoinColumn(name = "note_id"),
                    inverseJoinColumns = @JoinColumn(name = "tag_id")
            )
    List<TagEntity> tags;


}
