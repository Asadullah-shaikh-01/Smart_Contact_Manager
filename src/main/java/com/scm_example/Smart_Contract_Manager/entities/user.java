package com.scm_example.Smart_Contract_Manager.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class user implements UserDetails {
  @Id
  private String userId;
  @Column(name = "username", nullable = false)
  private String username;

  private String password;
  @Column(length = 1000)
  private String about;
  @Column(unique = true, nullable = false)
  private String email;
  private String phone;
   @Column(length = 1000)
  private String address;
   @Column(length = 1000)
  private String profileImageUrl;

     // ✅ Add this field
    @Column(name = "provider_user_id", length = 255)
    private String providerUserId;
    
  //information
  private boolean enabled=true;
  private boolean emailVerified=false;
  private boolean phoneVerified=false;

    // self, google, facebook
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('FACEBOOK','GOOGLE','SELF')")
    private Provider provider = Provider.SELF;




@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
 private List<Contact> contacts =new ArrayList<>();

 @ElementCollection(fetch = FetchType.EAGER)
private List<String>roleList =new ArrayList<>();


@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
   //List of roles {user ,Admin}
  // Collections of SimpleGrandAutority[roles{admin , USER}]
  Collection <SimpleGrantedAuthority> roles=  roleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

  return roles;
}


//for this project ;
//email id hai wahi hamra username 
@Override
public String getUsername(){
  return this.email;
}


@Override 
public boolean isAccountNonExpired(){
 
  return true;
}

@Override 
public boolean isAccountNonLocked(){
 
  return true;
}

@Override 
public boolean isCredentialsNonExpired(){
 
  return true;
}


@Override
public boolean isEnabled(){{
  return this.enabled;
}}


}
