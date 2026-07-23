package ec.edu.ups.icc.labevaluation.laboratories.mappers;
import ec.edu.ups.icc.labevaluation.laboratories.dtos.LaboratoryResponseDto;
import ec.edu.ups.icc.labevaluation.laboratories.entities.LaboratoryEntity;
public final class LaboratoryMapper {
    private LaboratoryMapper() {}
    public static LaboratoryResponseDto toResponse(LaboratoryEntity entity) {
        return new LaboratoryResponseDto(entity.getId(), entity.getCode(), entity.getName(), entity.getCapacity(), entity.getCampus().getName());
    }
}
