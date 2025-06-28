package com.school.Services;

import com.school.Entity.Registration;
import com.school.Repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationServices {

    @Autowired
    private RegistrationRepo registrationRepo;

    public List<Registration> findAllRegistrations() {
        return registrationRepo.findAll();
    }

    public Registration insertRegistration(Registration registration) {
        if (registration.getId() != null) {
            throw new RuntimeException("id should be null for new registration");
        }
        if (registration.getRegistrationDate() == null) {
            registration.setRegistrationDate(LocalDateTime.now());
        }
        return registrationRepo.save(registration);
    }

    public Registration updateRegistration(Long registrationId, Registration updatedRegistration) {
        Registration registration = registrationRepo.findById(registrationId).orElseThrow();
        registration.setStudent(updatedRegistration.getStudent());
        registration.setCourse(updatedRegistration.getCourse());
        registration.setPaymentStatus(updatedRegistration.getPaymentStatus());
        return registrationRepo.save(registration);
    }

    public void deleteRegistration(Long registrationId) {
        registrationRepo.deleteById(registrationId);
    }

    public Registration findRegistrationById(Long registrationId) {
        return registrationRepo.findById(registrationId).orElseThrow();
    }
}
