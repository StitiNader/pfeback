package com.contactApp.contactApp.controller;

import com.contactApp.contactApp.dto.LoginRequest;
import com.contactApp.contactApp.dto.LoginResponse;
import com.contactApp.contactApp.dto.MessageResponse;
import com.contactApp.contactApp.model.User;
import com.contactApp.contactApp.repository.UserRepository;
import com.contactApp.contactApp.services.AuthService;
import com.contactApp.contactApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
private final UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(authService.login(loginRequest.getEmail(), loginRequest.getPassword()));
        if(userRepository.findByEmail(loginRequest.getEmail()).isPresent()){
        loginResponse.setRole(userRepository.findByEmail(loginRequest.getEmail()).get().getRoles().get(0).getName());}
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    // END POINT register admin
    @PostMapping("/register")
    public ResponseEntity<?> registre(@RequestBody User user) {
        // verfication sur l'email
        System.out.println("sqdqsd");
        if (Boolean.TRUE.equals(userService.existByEmail(user.getEmail()))) {
            System.out.println("sqdqsd");

            return ResponseEntity.badRequest().body(new MessageResponse("Email Already Exist"));
        }
        System.out.println("sqdqsd");

        //add Role Admin to user
        return ResponseEntity.status(HttpStatus.OK).body(authService.registry(user));
    }
    //End Point register user


}
