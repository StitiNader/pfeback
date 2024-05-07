package com.contactApp.contactApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contactApp.contactApp.model.Contact; // Assurez-vous d'importer votre classe d'entité Contact ici

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    // Méthode pour supprimer un contact par ID
    void deleteById(Integer id);

}

