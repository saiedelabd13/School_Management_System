package com.school.Controller;

import com.school.Entity.Registration;
import com.school.Services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("registrations")
public class RegistrationController {

    @Autowired
    private RegistrationServices registrationService;

    @PostMapping("/addregistration")
    private Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.insertRegistration(registration);
    }

    @PutMapping("/updateregistration/{id}")
    private Registration updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        return registrationService.updateRegistration(id, registration);
    }

    @DeleteMapping("/deleteregistration/{id}")
    private void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @GetMapping("/findRegistrationById/{id}")
    private Registration findRegistrationById(@PathVariable Long id) {
        return registrationService.findRegistrationById(id);
    }

    @GetMapping("/findAllRegistrations")
    private List<Registration> findAllRegistrations() {
        return registrationService.findAllRegistrations();
    }

}
