package com.scm_example.Smart_Contract_Manager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class user {
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
  private boolean enabled=false;
  private boolean emailVerified=false;
  private boolean phoneVerified=false;

    // self, google, facebook
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('FACEBOOK','GOOGLE','SELF')")
    private Provider provider = Provider.SELF;




@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
 private List<Contact> contacts =new ArrayList<>();


}
