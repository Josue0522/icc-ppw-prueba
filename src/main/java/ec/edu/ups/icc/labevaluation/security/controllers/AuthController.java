package ec.edu.ups.icc.labevaluation.security.controllers;

import org.springframework.web.bind.annotation.*;
import ec.edu.ups.icc.labevaluation.security.dtos.*;
import ec.edu.ups.icc.labevaluation.security.services.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service) { this.service = service; }
    @PostMapping("/login")
    public AuthResponseDto login(@Valid @RequestBody LoginRequestDto dto) { return service.login(dto); }
    @PostMapping("/refresh")
    public AuthResponseDto refresh(@Valid @RequestBody RefreshTokenRequestDto dto) { return service.refresh(dto.refreshToken()); }
}
