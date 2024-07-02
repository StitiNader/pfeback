package com.contactApp.contactApp.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginResponse {
    private String token;
    private String role;
}
