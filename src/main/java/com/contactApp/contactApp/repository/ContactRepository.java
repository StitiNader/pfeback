package com.contactApp.contactApp.repository;

import com.contactApp.contactApp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    // Méthode pour supprimer un contact par ID
    void deleteById(Integer id);

    boolean existsByNumeroTel(Integer num_tel);

    Contact findByNumeroTel(Integer num_tel);

    List<Contact> findContactsByNomContainingIgnoreCase(String name);
}

