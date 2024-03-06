package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {
    public static final String USER = "USER";

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        // logic to load user from DB
        var user = appUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found"));
        return user;
    }
}
