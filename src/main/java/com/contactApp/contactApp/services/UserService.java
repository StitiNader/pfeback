package com.contactApp.contactApp.services;

import com.contactApp.contactApp.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    void deleteUserById(Integer id);

    User getUserById(Integer id);

    List<User> getAllUsers();

    boolean existByEmail(String email);


    User updateUserPut(Integer id, User user);
}
