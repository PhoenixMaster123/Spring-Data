package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT d FROM Device d " +
            "WHERE d.deviceType = :deviceType " +
            "AND d.price <= :maxPrice " +
            "AND d.storage >= :minStorageInclusive " +
            "ORDER BY LOWER(d.brand)")
    List<Device> findExportable (DeviceType deviceType, Double maxPrice, Integer minStorageInclusive);
}
