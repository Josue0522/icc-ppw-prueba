package ec.edu.ups.icc.labevaluation.supplies.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.labevaluation.supplies.entities.SupplyEntity;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {

    boolean existsByNameIgnoreCaseAndDeletedFalse(String name);

    List<SupplyEntity> findByActiveTrueAndDeletedFalseAndQuantityLessThanOrderByQuantityAsc(Integer maxQuantity);

    Optional<SupplyEntity> findByIdAndDeletedFalse(Long id);
}