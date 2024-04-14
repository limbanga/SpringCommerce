package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.appexceptions.CustomValidationException;
import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.repositories.AppUserRepository;
import com.example.SpringCommerce.limbanga.requests.AuthenticationRequest;
import com.example.SpringCommerce.limbanga.requests.RegisterRequest;
import com.example.SpringCommerce.limbanga.responses.AuthenticationResponse;
import com.example.SpringCommerce.limbanga.services.AppUserService;
import com.example.SpringCommerce.limbanga.services.JwtTokenService;
import com.example.SpringCommerce.limbanga.services.JwtUserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenService jwtTokenService;
    private final AppUserService appUserService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody @Valid final AuthenticationRequest authenticationRequest) {
        // get username and password from request
        var username = authenticationRequest.getUsername();
        var password = authenticationRequest.getPassword();
        // authenticate user
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        } catch (final BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        // success -> load user from db
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
        return authenticationResponse;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest registerRequest
    )
            throws CustomValidationException {
        appUserService.register(registerRequest);
        return ResponseEntity.ok("Register successfully");
    }

}