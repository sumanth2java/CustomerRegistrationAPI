package com.registration.customer.controller;

import com.registration.customer.entity.LoginEntity;
import com.registration.customer.entity.RegistrationEntity;
import com.registration.customer.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@CrossOrigin("http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private LoginEntity loginEntity;


//    @PostMapping("/login")
//    public String loginCustomer(@RequestBody LoginEntity loginEntity) {
//       return "Login Successful";
//    }

    @PostMapping("/addCustomer")
    public String addCustomerDetails(@RequestBody RegistrationEntity registrationEntity){
        registrationRepository.save(registrationEntity);
        return "Customer details are added";
    }

    @GetMapping("/getCustomer")
    public List<RegistrationEntity> getCustomerDetails(){
        return registrationRepository.findAll();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello, this is tomcat";
    }

}