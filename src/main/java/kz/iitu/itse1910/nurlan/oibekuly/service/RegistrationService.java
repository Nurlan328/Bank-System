package kz.iitu.itse1910.nurlan.oibekuly.service;

import kz.iitu.itse1910.nurlan.oibekuly.repository.RegistrationRepository;
import kz.iitu.itse1910.nurlan.oibekuly.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    public RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Users> getAllUsers() {
        return registrationRepository.getAllUsers();
    }
    public Users findUserById(int id) {
        return registrationRepository.findById(id);
    }
    
    public void updatePhotoByUsername(byte[] photo, String username) {
        registrationRepository.updatePhotoByUsername(photo, username);
    }

    public Users findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }

}
