package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.Country;

@Repository
public interface CountryDAO extends JpaRepository<Country, Long> {
}
