package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.WineInfo;
@Repository
public interface WineInfoDAO extends JpaRepository<WineInfo, Long> {
}
