package com.contactApp.contactApp.services;

import com.contactApp.contactApp.model.App_User;


public interface UserService   {
    void addUser(App_User user);
    void updateUser(App_User user);
    void deleteUser(int id);
    App_User getUser(int id);
}
