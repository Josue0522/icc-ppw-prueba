package ec.edu.ups.icc.labevaluation.users.services;
import java.util.List;
import ec.edu.ups.icc.labevaluation.users.dtos.UserResponseDto;
public interface UserService { List<UserResponseDto> findEligible(); }
