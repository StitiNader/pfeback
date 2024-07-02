package com.contactApp.contactApp.services.impl;

import com.contactApp.contactApp.model.User;
import com.contactApp.contactApp.repository.UserRepository;
import com.contactApp.contactApp.security.jwt.JwtProvider;
import com.contactApp.contactApp.security.jwt.service.UserPrinciple;
import com.contactApp.contactApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RestTemplateAutoConfiguration restTemplateAutoConfiguration;

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );
        assert user != null;
        return jwtProvider.generateToken(UserPrinciple.build(user));
    }

    @Override
    public User registry(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
