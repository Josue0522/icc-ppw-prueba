package ec.edu.ups.icc.labevaluation.users.dtos;

import java.util.Set;

public record UserResponseDto(
        Long id,
        String fullName,
        String email,
        Integer age,
        boolean active,
        Set<String> roles
) {}