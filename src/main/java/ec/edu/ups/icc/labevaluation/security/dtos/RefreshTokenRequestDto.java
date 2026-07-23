package ec.edu.ups.icc.labevaluation.security.dtos;
import jakarta.validation.constraints.NotBlank;
public record RefreshTokenRequestDto(@NotBlank String refreshToken) {}
