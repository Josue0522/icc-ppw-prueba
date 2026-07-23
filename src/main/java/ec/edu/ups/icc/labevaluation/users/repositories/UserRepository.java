package ec.edu.ups.icc.labevaluation.users.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.labevaluation.users.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndDeletedFalse(String email);
    Optional<UserEntity> findByIdAndActiveTrueAndDeletedFalse(Long id);
}
