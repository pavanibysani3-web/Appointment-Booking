package com.abs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abs.dto.LoginRequest;
import com.abs.dto.LoginResponse;
import com.abs.entity.User;
import com.abs.repository.UserRepository;
import com.abs.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        Optional<User> user =
                userRepository.findByEmail(request.getEmail());

        if (user.isPresent()
                && user.get().getPassword()
                        .equals(request.getPassword())) {

            String token =
                    jwtUtil.generateToken(
                            user.get().getEmail(),
                            user.get().getRole()
                    );

            return new LoginResponse(
                    token,
                    user.get().getRole()
            );
        }

        return new LoginResponse(
                "Invalid Credentials",
                ""
        );
    }
    
    
}