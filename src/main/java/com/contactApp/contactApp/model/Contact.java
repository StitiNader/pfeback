package com.contactApp.contactApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prenom;

    private String nom;

    private String entreprise;

    private String service;

    private String fonction;

    private String email;

    private int numeroTel;

    private String image;

    private Date datedenaissance;

    private String commentaire;
    @OneToOne
    private User user;
}
