package ec.edu.ups.icc.labevaluation.security.utils;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import ec.edu.ups.icc.labevaluation.security.config.JwtProperties;
import ec.edu.ups.icc.labevaluation.security.services.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final JwtProperties properties;
    private final SecretKey key;
    public JwtUtil(JwtProperties properties) {
        this.properties = properties;
        this.key = Keys.hmacShaKeyFor(properties.getSecret().getBytes(StandardCharsets.UTF_8));
    }
    public String generateAccessToken(UserDetailsImpl user) {
        Instant now = Instant.now();
        return Jwts.builder()
            .subject(user.getUsername())
            .issuer(properties.getIssuer())
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plusMillis(properties.getExpiration())))
            .claim("uid", user.getId())
            .claim("roles", user.getAuthorities().stream().map(Object::toString).toList())
            .signWith(key)
            .compact();
    }
    public String extractUsername(String token) { return parse(token).getSubject(); }
    public boolean isValid(String token) {
        try { parse(token); return true; } catch (Exception ex) { return false; }
    }
    private Claims parse(String token) {
        return Jwts.parser().verifyWith(key).requireIssuer(properties.getIssuer()).build()
            .parseSignedClaims(token).getPayload();
    }
    public long getExpirationMillis() { return properties.getExpiration(); }
}
