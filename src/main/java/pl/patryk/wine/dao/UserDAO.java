package pl.patryk.wine.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.wine.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
