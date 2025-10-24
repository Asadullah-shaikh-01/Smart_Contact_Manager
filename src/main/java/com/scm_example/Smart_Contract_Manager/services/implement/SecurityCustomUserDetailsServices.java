package com.scm_example.Smart_Contract_Manager.services.implement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm_example.Smart_Contract_Manager.repositories.userRepo;

@Service
public class SecurityCustomUserDetailsServices implements UserDetailsService {

    private userRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // apna user ko load karna hai
        return userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found :" + username));
    }

}
