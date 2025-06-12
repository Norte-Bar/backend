package com.nortebar.api.app.services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.nortebar.api.commons.utils.FuncionarioAuthenticated;

@Service
public class JwtService {

    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        long expiry = 3600L;

        String scopes = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

        FuncionarioAuthenticated funcionarioAuth = (FuncionarioAuthenticated) authentication.getPrincipal();

        Integer id = funcionarioAuth.getFuncionario().getId();

        var claims = JwtClaimsSet.builder()
        .issuer("myNorteBar")
        .issuedAt(now)
        .expiresAt(now.plusSeconds(expiry))
        .subject(authentication.getName())
        .claim("scope", scopes)
        .claim("id", id)
        .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
