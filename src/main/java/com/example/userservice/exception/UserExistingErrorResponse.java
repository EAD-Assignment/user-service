package com.example.userservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExistingErrorResponse {

    private String message;
    private String details;

    // Constructors, getters, and setters
}
