package ec.edu.ups.icc.labevaluation.security.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record LoginRequestDto(@NotBlank @Email String email, @NotBlank String password) {}
