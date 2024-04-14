package com.example.SpringCommerce.limbanga.requests;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegisterRequest {
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^((\\+|00)84|0)(3[2-9]|5[2689]|7[06-9]|8[1-689]|9[0-46-9])([0-9]{7,8})$", message = "Invalid phone number")
    private String phoneNumber;
    @NotEmpty(message = "Username is required")
    @Email(message = "Invalid email format")
    private String username;
    @NotEmpty(message = "Password is required")
    @Length(min = 6, message = "Password must be at least 6 characters")
    @Length(max = 20, message = "Password must be at most 20 characters")
    private String password;
}
