package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.repositories.AppUserRepository;
import com.example.SpringCommerce.limbanga.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public void register(RegisterRequest registerRequest) {
        var hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        var appUser = AppUser.builder().username(registerRequest.getUsername())
                .password(hashedPassword)
                .build();
        appUserRepository.save(appUser);
    }
}
