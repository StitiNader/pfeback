package com.contactApp.contactApp.services.impl;
import com.contactApp.contactApp.model.App_User;
import com.contactApp.contactApp.repository.UserRepository;
import com.contactApp.contactApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public void addUser(App_User user) {
        UserRepository.save(user);
    }

    public void updateUser(App_User user) {
        UserRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        UserRepository.deleteById(id);
    }

    @Override
    public App_User getUser(int id) {
        return null;
    }
}
