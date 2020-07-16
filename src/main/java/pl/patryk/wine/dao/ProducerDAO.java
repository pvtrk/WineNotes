package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.Producer;

@Repository
public interface ProducerDAO extends JpaRepository<Producer, Long> {
}
