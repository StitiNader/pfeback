package com.contactApp.contactApp.services;

import com.contactApp.contactApp.model.User;

public interface AuthService {
    String login(String email, String password);

    User registry(User user);
}
