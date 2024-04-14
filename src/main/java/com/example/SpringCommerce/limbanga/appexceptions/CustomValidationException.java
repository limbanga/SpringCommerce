package com.example.SpringCommerce.limbanga.appexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomValidationException extends Exception {
    private String fieldName;
    private String errorMessage;
}
