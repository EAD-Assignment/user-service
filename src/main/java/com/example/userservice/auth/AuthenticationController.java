package com.example.userservice.auth;

import com.example.userservice.exception.UserRegistrationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            // Attempt to register the user
            AuthenticationResponse response = service.register(request);

            // Customize the success response
            Map<String, String> successResponse = new HashMap<>();

            successResponse.put("details", "User registered successfully");
            successResponse.put("username", request.getEmail()); // Include any relevant details

            return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
        } catch (UserRegistrationException ex) {
            // Handle the exception and return a meaningful error response
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "User registration failed");
            errorResponse.put("details", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception ex) {
            // Handle other exceptions if needed
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Internal server error");
            errorResponse.put("details", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }






    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refreshToken")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    )throws IOException {
            service.refreshToken(request, response);
    }
}
