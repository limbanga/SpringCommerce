package com.example.SpringCommerce.limbanga.requests;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationRequest {
    @NotEmpty(message = "Username is required")
    @Email(message = "Invalid email")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
}
