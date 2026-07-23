package ec.edu.ups.icc.labevaluation.laboratories.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.ups.icc.labevaluation.core.exceptions.domain.NotFoundException;
import ec.edu.ups.icc.labevaluation.laboratories.dtos.LaboratoryResponseDto;
import ec.edu.ups.icc.labevaluation.laboratories.mappers.LaboratoryMapper;
import ec.edu.ups.icc.labevaluation.laboratories.repositories.LaboratoryRepository;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {

    private final LaboratoryRepository repository;

    public LaboratoryServiceImpl(LaboratoryRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LaboratoryResponseDto> findAvailable(Long campusId, Integer minCapacity) {
        return repository.findByCampus_IdAndCapacityGreaterThanEqualAndActiveTrueAndDeletedFalseAndCampus_ActiveTrueAndCampus_DeletedFalseOrderByCapacityDesc(
                        campusId, minCapacity)
                .stream()
                .map(LaboratoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LaboratoryResponseDto findOne(Long id) {
        return repository.findById(id)
                .filter(lab -> !lab.isDeleted())
                .map(LaboratoryMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("LAB_NOT_FOUND", "Laboratory not found"));
    }
}