package com.scm_example.Smart_Contract_Manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm_example.Smart_Contract_Manager.services.implement.SecurityCustomUserDetailsServices;

@Configuration
public class SecurityConfig {

    // create user and login in using java code with memory services
    // @Bean
    // public UserDetailsService userDetailServices() {
    // UserDetails user1 =
    // user.username("admin123").password("admin123").roles("admin",
    // "users").build();

    // UserDetails user2 =
    // user.username("admin123").password().roles("users").build();

    // var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

    // return inMemoryUserDetailsManager;

    @Autowired
    private SecurityCustomUserDetailsServices userDetailsServices;

    // Confihguration of Authentication provideer for Spring Security
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // User Details Services ka Object
        daoAuthenticationProvider.setUserDetailsService(userDetailsServices);
        // password Encoded ka Object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    //
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // configurtion

        // user configustion kiya hai ki kounn se public rahenge or koun sa private
        httpSecurity.authorizeHttpRequests(authorize -> {
            // authorize.requestMatchers("/home","/register","/login").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();

        });

        // form default login 
        //ager hamee  kuch bhi change karna ho gaa to hum yaha aayenge
      httpSecurity.formLogin(formLogin->{
        formLogin.loginPage("/login");
      });

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
