package com.example.SpringCommerce.limbanga.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    // todo: add validation email
    private String username;
    private String password;
    private String displayName;
}
