package ec.edu.ups.icc.labevaluation.laboratories.services;
import java.util.List;
import ec.edu.ups.icc.labevaluation.laboratories.dtos.LaboratoryResponseDto;
public interface LaboratoryService {
    List<LaboratoryResponseDto> findAvailable(Long campusId, Integer minCapacity);
    LaboratoryResponseDto findOne(Long id);
}
