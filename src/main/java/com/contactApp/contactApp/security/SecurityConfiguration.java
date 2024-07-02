package com.contactApp.contactApp.security;

import com.contactApp.contactApp.security.jwt.JwtAuthEntryPoint;
import com.contactApp.contactApp.security.jwt.JwtAuthTokenFiltre;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthEntryPoint jwtAuthEntryPoint;
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthTokenFiltre jwtAuthTokenFiltre;
    private static final String[] WHITE_LIST_URL = {
            "*"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint))
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).sessionManagement(session ->session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthTokenFiltre, UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }
}
