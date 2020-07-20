package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.Note;

import java.util.List;

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {
    @Query("SELECT n FROM tnote n WHERE user_id =:userId")
    List<Note> findNotesForUser(@Param("userId") Long id);
}
