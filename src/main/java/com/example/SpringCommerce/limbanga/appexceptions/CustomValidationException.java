package com.example.SpringCommerce.limbanga.appexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomValidationException extends Exception {
    private String fieldName;
    private String errorMessage;
}
