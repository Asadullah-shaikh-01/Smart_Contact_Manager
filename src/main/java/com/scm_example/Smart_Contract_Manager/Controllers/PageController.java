package com.scm_example.Smart_Contract_Manager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm_example.Smart_Contract_Manager.entities.Provider;
import com.scm_example.Smart_Contract_Manager.entities.user;
import com.scm_example.Smart_Contract_Manager.forms.UserForm;
import com.scm_example.Smart_Contract_Manager.helper.Message;
import com.scm_example.Smart_Contract_Manager.helper.MessageType;
import com.scm_example.Smart_Contract_Manager.services.userServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

  @Autowired
  private userServices userServices;

    @RequestMapping("/")
  public String index() {
    System.out.println("home");
    return "redirect:/home";

  }



  @RequestMapping("/home")
  public String home() {
    System.out.println("home");
    return "home";

  }

  @RequestMapping("/services")
  public String servives() {
    System.out.println("Services Pages");
    return "services";
  }

  @RequestMapping("/about")
  public String about() {
    System.out.println("about");
    return "about";
  }

  @RequestMapping("/contact")
  public String contact() {
    System.out.println("contact");
    return "contact";
  }

  @RequestMapping("/login")
  public String login() {
    System.out.println("login");
    return "login";
  }

  @RequestMapping("/register")
  public String register(Model model) {

    UserForm userForm = new UserForm();

    model.addAttribute("userForm", userForm);

    return "register";
  }

  // processing Register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String proccessRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session) {
    System.out.println("Process Register");
    // fatch form data
    // user form data
    System.out.println(userForm);
    // validation form data
 
    if(rBindingResult.hasErrors()){
      return  "register";
    }

    // save to database

    // user services
    // userForm --> user
    // user newUser = user.builder()
    // .username(userForm.getUsername())
    // .email(userForm.getEmail())
    // .password(userForm.getPassword())
    // .about(userForm.getAbout())
    // .phone(userForm.getPhone())
    // .profileImageUrl("/static/images/imageProfile.png")
    // .build();

    user newUser = new user();
    newUser.setUsername(userForm.getUsername());
    newUser.setEmail(userForm.getEmail());
    newUser.setPassword(userForm.getPassword());
    newUser.setAbout(userForm.getAbout());
    newUser.setPhone(userForm.getPhone());
    newUser.setProfileImageUrl("/images/imageProfile.png");
    newUser.setEnabled(false);
    // ✅ Important: set provider explicitly
    newUser.setProvider(Provider.SELF);

    System.out.println("User saved");

    user savedUser = userServices.SaveUser(newUser);

    // message = "Register Sucessfully"

    Message NewMessage = Message.builder().content("Register Successfull").type(MessageType.green).build();
    session.setAttribute("message", NewMessage);



    // Redirect to login Page
    return "redirect:/register";
  }

}
