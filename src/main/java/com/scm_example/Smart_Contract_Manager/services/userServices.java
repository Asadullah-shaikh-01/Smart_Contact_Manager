package com.scm_example.Smart_Contract_Manager.services;

import java.util.List;
import java.util.Optional;

import com.scm_example.Smart_Contract_Manager.entities.user;

public interface userServices {

    user SaveUser(user user);
    Optional <user> getUserById(String Id);
    Optional <user> updateUser(user user);
    void deleteUser(String id);
    boolean isUserExist(String id);
    boolean isUserExistByEmail(String email);

    List<user> getAllUsers();

    // add more method related User Services 
}
