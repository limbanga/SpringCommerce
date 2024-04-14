package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.appexceptions.CustomValidationException;
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

    public void register(RegisterRequest registerRequest)
            throws CustomValidationException {
    // check if the username is already taken
    if (appUserRepository.existsByUsername(registerRequest.getUsername())) {
        throw new CustomValidationException("username", "Username is already taken");
    }

    // check phoneNumber is existed
    if (appUserRepository.existsByPhoneNumber(registerRequest.getPhoneNumber())) {
        throw new CustomValidationException("phoneNumber", "Phone number is already taken");
    }

    var hashedPassword = passwordEncoder.encode(registerRequest.getPassword());

    var appUser = AppUser.builder()
            .firstName(registerRequest.getFirstName())
            .lastName(registerRequest.getLastName())
            .phoneNumber(registerRequest.getPhoneNumber())
            .username(registerRequest.getUsername())
            .password(hashedPassword)
            .build();

    appUserRepository.save(appUser);
}
}
