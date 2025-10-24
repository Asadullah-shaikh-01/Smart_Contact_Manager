package com.scm_example.Smart_Contract_Manager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user")

public class UserController {

    //User Dashboard page
    @RequestMapping(value = "/dashboard", method=RequestMethod.GET)
    public String requestMethodName(@RequestParam String param) {
        return "user/dashboard";
    }
   
       // user profile page

    @RequestMapping(value = "/profile")
    public String userProfile() {

        return "user/profile";
    }

    //user add contact page

    //user view contact page

    //user edite page 

    //user delete page

    //user search page

}
