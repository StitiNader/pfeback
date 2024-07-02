package com.contactApp.contactApp.configuartion;

import com.contactApp.contactApp.model.Role;
import com.contactApp.contactApp.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitRole {
    private final RoleRepository roleRepository;
    @PostConstruct
    public void init(){
        saveRoles();
    }
    private void saveRoles(){
        List<Role> roleList = roleRepository.findAll();
        if(roleList.isEmpty()){
            roleRepository.save(new Role("ROLE_ADMIN"));
            roleRepository.save(new Role("ROLE_CLIENT"));
        }
    }
}
