package com.contactApp.contactApp.services.impl;

import com.contactApp.contactApp.model.User;
import com.contactApp.contactApp.repository.UserRepository;
import com.contactApp.contactApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
     return  userRepository.save(user);
    }

    @Override
    public User updateUserPut(Integer id, User user){
        User usr= userRepository.findById(id).get();
            usr.setFirstname(  user.getFirstname()  );
            usr.setLastname( user.getLastname()  );
            return userRepository.save(user);

    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
