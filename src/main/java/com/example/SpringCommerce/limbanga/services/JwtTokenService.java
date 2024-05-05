package com.example.SpringCommerce.limbanga.services;

import ch.qos.logback.classic.Logger;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class JwtTokenService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JwtTokenService.class);
    @Value("${jwt.duration-millisecond}")
    private Long jwtDuration;
    private final Algorithm hmac512;
    private final JWTVerifier verifier;

    public JwtTokenService(@Value("${jwt.secret}") final String secret) {
        this.hmac512 = Algorithm.HMAC512(secret);
        this.verifier = JWT.require(this.hmac512).build();
    }

    public String generateToken(final UserDetails userDetails) {
        final Instant now = Instant.now();
        final String role = userDetails.getAuthorities().stream().findFirst().orElseThrow().getAuthority();
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("username", userDetails.getUsername())
                .withClaim("role", role)
                .withIssuer("limbanga")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(jwtDuration))
                .sign(this.hmac512);
    }

    public String validateTokenAndGetUsername(final String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationEx) {
            log.warn("token invalid: {}", verificationEx.getMessage());
            return null;
        }
    }

}
