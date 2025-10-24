package com.scm_example.Smart_Contract_Manager.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

     private String username;
       private String password;
         private String email;
             private String phone;  
             private String address;
                 private String about; 
}
