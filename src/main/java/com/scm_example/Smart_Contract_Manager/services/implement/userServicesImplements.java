package com.scm_example.Smart_Contract_Manager.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm_example.Smart_Contract_Manager.entities.user;
import com.scm_example.Smart_Contract_Manager.helper.AppConstant;
import com.scm_example.Smart_Contract_Manager.helper.ResourceNotFoundException;
import com.scm_example.Smart_Contract_Manager.repositories.userRepo;
import com.scm_example.Smart_Contract_Manager.services.userServices;

@Service
public class userServicesImplements implements userServices {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public user SaveUser(user user) {
        // user Id : have to genrate dynamic way
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        // password Encode
        // user.setPassword(userId);
   user.setPassword(passwordEncoder.encode(user.getPassword()));


   // set the user roles
   user.setRoleList(List.of(AppConstant.ROLE_USER));

   logger.info(user.getProvider().toString());
        return userRepo.save(user);
    }

    @Override
    public Optional<user> getUserById(String Id) {

        return userRepo.findById(Id);
    }

    @Override
    public Optional<user> updateUser(user user) {

        user user1 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        // update karenge User 1 ko from user
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhone(user.getPhone());
        user1.setProfileImageUrl(user.getProfileImageUrl());
        user1.setEnabled(user.isEnabled());
        user1.setEmailVerified(user.isEmailVerified());
        user1.setPhoneVerified(user.isPhoneVerified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());

        // save the user in database
        user save = userRepo.save(user1);

        return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {

        user user1 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        userRepo.delete(user1);
    }

    @Override
    public boolean isUserExist(String id) {

        user user1 = userRepo.findById(id).orElse(null);
        return user1 != null ? true : false;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
        user user1 = userRepo.findByEmail(email).orElse(null);
        return user1 != null ? true : false;
    }

    @Override
    public List<user> getAllUsers() {

        return userRepo.findAll();
    }

}
