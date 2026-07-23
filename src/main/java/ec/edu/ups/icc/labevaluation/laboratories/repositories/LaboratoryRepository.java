package ec.edu.ups.icc.labevaluation.laboratories.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.labevaluation.laboratories.entities.LaboratoryEntity;

public interface LaboratoryRepository extends JpaRepository<LaboratoryEntity, Long> {
    List<LaboratoryEntity> findByActiveTrueAndDeletedFalseOrderByIdAsc();

    List<LaboratoryEntity> findByCampus_IdAndCapacityGreaterThanEqualAndActiveTrueAndDeletedFalseAndCampus_ActiveTrueAndCampus_DeletedFalseOrderByCapacityDesc(
            Long campusId, Integer minCapacity);
}