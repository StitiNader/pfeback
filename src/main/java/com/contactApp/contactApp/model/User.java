package com.contactApp.contactApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @ManyToMany
    List<Role> roles ;
}
