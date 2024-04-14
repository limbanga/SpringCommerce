package com.example.SpringCommerce.limbanga.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
}
