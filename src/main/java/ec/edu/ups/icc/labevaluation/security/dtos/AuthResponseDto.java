package ec.edu.ups.icc.labevaluation.security.dtos;
public record AuthResponseDto(String accessToken, String refreshToken, long expiresIn) {}
