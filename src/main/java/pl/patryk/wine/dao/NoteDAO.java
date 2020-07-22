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
    List<Note> findAllNotesForUser(@Param("userId") Long id);

   @Query("SELECT n FROM tnote n WHERE user_id =:userId AND lower(n.wine.name) LIKE LOWER(concat('%', :searchTerm, '%') )" +
            "OR lower (n.wineColor) LIKE lower(concat('%', :searchTerm, '%') ) " +
            "OR lower (n.wine.country.countryName) LIKE lower(concat('%', :searchTerm, '%') )" +
            "OR lower (n.wine.producer.name) LIKE lower(concat('%', :searchTerm, '%') )")
    List<Note> findSearchedNotes(@Param("userId") Long id, @Param("searchTerm") String searchTerm);



}
