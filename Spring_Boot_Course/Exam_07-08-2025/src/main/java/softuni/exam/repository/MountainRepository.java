package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mountain;

import java.util.List;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long> {
    @Query("SELECT m FROM Mountain m " +
            "WHERE m.elevation >= 3000 " +
            "AND m.hardToReach = true " +
            "ORDER BY m.elevation DESC")
    List<Mountain> exportMountains();
}
