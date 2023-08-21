package com.registration.customer.service;

import com.registration.customer.entity.CustomUserDetails;
import com.registration.customer.entity.RegistrationEntity;
import com.registration.customer.repository.RegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements UserDetailsService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegistrationEntity user = registrationRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new CustomUserDetails(user.getUserName(), user.getPassword(), user.isEnabled());
    }
}