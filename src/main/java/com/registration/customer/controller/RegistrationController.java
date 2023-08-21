package com.registration.customer.controller;

import com.registration.customer.entity.LoginEntity;
import com.registration.customer.entity.RegistrationEntity;
import com.registration.customer.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginEntity loginEntity) {
        try {
            System.out.println("User details:: " + loginEntity.getUserName() +"password:: "+ loginEntity.getPassword());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginEntity.getUserName(), loginEntity.getPassword()));

            System.out.println("Now the auth is done moving to fetching user details");
            RegistrationEntity userDetails = registrationRepository.findByUserName(loginEntity.getUserName());
            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @PostMapping("/addCustomer")
    public String addCustomerDetails(@RequestBody RegistrationEntity registrationEntity){
        System.out.println(registrationEntity.getPassword());
        String encodedPassword = passwordEncoder.encode(registrationEntity.getPassword());
        registrationEntity.setPassword(encodedPassword);
        registrationRepository.save(registrationEntity);
        return "Customer details are added";
    }

    @GetMapping("/getCustomer")
    public List<RegistrationEntity> getCustomerDetails(){
        return registrationRepository.findAll();
    }

}