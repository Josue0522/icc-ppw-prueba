package ec.edu.ups.icc.labevaluation.users.services;
import java.util.List;
import org.springframework.stereotype.Service;
import ec.edu.ups.icc.labevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.labevaluation.users.mappers.UserMapper;
import ec.edu.ups.icc.labevaluation.users.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    public UserServiceImpl(UserRepository repository){this.repository=repository;}
    @Override public List<UserResponseDto> findEligible(){
        return repository.findAll().stream().filter(user -> !user.isDeleted()).map(UserMapper::toResponse).toList();
    }
}
