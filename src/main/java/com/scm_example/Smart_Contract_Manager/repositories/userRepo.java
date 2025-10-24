package com.scm_example.Smart_Contract_Manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm_example.Smart_Contract_Manager.entities.user;

@Repository()
public interface userRepo extends JpaRepository<user, String> {

    // extra methods db RelatedOperation
    // Custome Query methods
    //Single Custom filed Finder methods 
 Optional<user> findByEmail(String email);
    
 //mutilpe Custom Filed Method Finder
 Optional <user> findByEmailAndPassword(String email,String password);

}