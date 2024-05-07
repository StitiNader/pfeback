package com.contactApp.contactApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class App_User {

    @Id
    @GeneratedValue
    private Integer  id;

    private String email;

    private Integer age;

    private String password;
}
