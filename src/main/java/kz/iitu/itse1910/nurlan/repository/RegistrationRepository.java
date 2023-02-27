package kz.iitu.itse1910.nurlan.repository;

import kz.iitu.itse1910.nurlan.model.Users;

import java.util.List;


public interface RegistrationRepository {

    void updatePhotoByUsername(byte[] photo, String username);

    Users findByUsername(String username);

    List<Users> getAllUsers();

    List<Users> findAll();

    Users save(Users user);

    Users findById(int id);
}
