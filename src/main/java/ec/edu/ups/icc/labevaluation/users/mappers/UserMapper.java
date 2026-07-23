package ec.edu.ups.icc.labevaluation.users.mappers;
import ec.edu.ups.icc.labevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.labevaluation.users.entities.UserEntity;
public final class UserMapper {
    private UserMapper() {}
    public static UserResponseDto toResponse(UserEntity entity){
        return new UserResponseDto(entity.getId(), entity.getFullName(), entity.getEmail());
    }
}
