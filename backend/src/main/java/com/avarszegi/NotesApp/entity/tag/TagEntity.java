package com.avarszegi.NotesApp.entity.tag;

import com.avarszegi.NotesApp.entity.note.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Relácia reprezentujúca tagy, jeden tag môže byť na viacerých poznámkach a jedna poznámka môže mat viacero tagov


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    // Tento vzťah je vlastnený poľom tags v NoteEntity

    @ManyToMany(mappedBy = "tags")
    List<NoteEntity> notes;

}
