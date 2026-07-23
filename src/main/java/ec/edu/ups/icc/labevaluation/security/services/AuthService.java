package ec.edu.ups.icc.labevaluation.security.services;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.ups.icc.labevaluation.core.exceptions.domain.BadRequestException;
import ec.edu.ups.icc.labevaluation.security.config.JwtProperties;
import ec.edu.ups.icc.labevaluation.security.dtos.AuthResponseDto;
import ec.edu.ups.icc.labevaluation.security.dtos.LoginRequestDto;
import ec.edu.ups.icc.labevaluation.security.entities.RefreshTokenEntity;
import ec.edu.ups.icc.labevaluation.security.repositories.RefreshTokenRepository;
import ec.edu.ups.icc.labevaluation.security.utils.JwtUtil;
import ec.edu.ups.icc.labevaluation.users.repositories.UserRepository;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final JwtProperties properties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, JwtProperties properties,
            RefreshTokenRepository refreshTokenRepository, UserDetailsServiceImpl userDetailsService,
            UserRepository userRepository) {
        this.authenticationManager = authenticationManager; this.jwtUtil = jwtUtil; this.properties = properties;
        this.refreshTokenRepository = refreshTokenRepository; this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }
    @Transactional
    public AuthResponseDto login(LoginRequestDto dto) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        String access = jwtUtil.generateAccessToken(user);
        RefreshTokenEntity refresh = new RefreshTokenEntity();
        refresh.setToken(UUID.randomUUID().toString());
        refresh.setUser(userRepository.findById(user.getId()).orElseThrow());
        refresh.setExpiresAt(LocalDateTime.now().plusNanos(properties.getRefreshExpiration() * 1_000_000));
        refreshTokenRepository.save(refresh);
        return new AuthResponseDto(access, refresh.getToken(), properties.getExpiration());
    }
    @Transactional(readOnly = true)
    public AuthResponseDto refresh(String token) {
        RefreshTokenEntity entity = refreshTokenRepository.findByTokenAndRevokedFalse(token)
            .filter(value -> value.getExpiresAt().isAfter(LocalDateTime.now()))
            .orElseThrow(() -> new BadRequestException("INVALID_REFRESH_TOKEN", "Invalid refresh token"));
        UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(entity.getUser().getEmail());
        return new AuthResponseDto(jwtUtil.generateAccessToken(user), token, properties.getExpiration());
    }
}
