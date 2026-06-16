package com.avarszegi.NotesApp.repository.note;

import com.avarszegi.NotesApp.entity.note.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, UUID> {
}
