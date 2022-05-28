package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Users;

import java.util.List;


public interface RegistrationRepository {

//    @Modifying
//    @Query("update Users u set u.photo = ?1 where u.username = ?2")
    void updatePhotoByUsername(byte[] photo, String username);

    Users findByUsername(String username);

    List<Users> getAllUsers();

    List<Users> findAll();

    Users save(Users user);

    Users findById(int id);
}
