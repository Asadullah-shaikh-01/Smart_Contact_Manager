package com.scm_example.Smart_Contract_Manager.helper;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
     super(message);
    }

    public ResourceNotFoundException( ){
     super("Resource Not Found");
    }
}
