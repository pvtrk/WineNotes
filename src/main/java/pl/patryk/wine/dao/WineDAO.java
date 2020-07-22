package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.Wine;

@Repository
public interface WineDAO extends JpaRepository<Wine, Long> {
    //@Query("SELECT w FROM twine w WHERE ")
}
