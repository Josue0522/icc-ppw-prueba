package ec.edu.ups.icc.labevaluation.users.controllers;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ec.edu.ups.icc.labevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.labevaluation.users.services.UserService;
@RestController @RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){this.service=service;}
    @GetMapping("/eligible") @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> findEligible(){return service.findEligible();}
}
