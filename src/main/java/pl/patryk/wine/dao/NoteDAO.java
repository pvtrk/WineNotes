package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.Note;

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {
}
