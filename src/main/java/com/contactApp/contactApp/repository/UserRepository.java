package com.contactApp.contactApp.repository;

import com.contactApp.contactApp.model.App_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<App_User,Integer> {
}

