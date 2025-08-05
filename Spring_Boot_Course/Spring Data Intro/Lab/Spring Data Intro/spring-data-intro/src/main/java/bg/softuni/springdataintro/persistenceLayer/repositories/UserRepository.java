package bg.softuni.springdataintro.persistenceLayer.repositories;

import bg.softuni.springdataintro.persistenceLayer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByAgeGreaterThan(int age);
}
