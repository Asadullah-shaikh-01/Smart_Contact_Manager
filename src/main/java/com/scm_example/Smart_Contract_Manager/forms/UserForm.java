package com.scm_example.Smart_Contract_Manager.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

  @NotBlank(message = "Username is required")
  @Size(min = 3, message = "Min 3 Characters is required")
  private String username;
  @NotBlank(message = "Password is required")
  @Size(min = 6, message = "min 6 Chaarcter is required")
  private String password;
  @NotBlank(message = "Email is required")
  @Email(message = "Invalid Email address")
  private String email;
  @NotBlank(message = "Phone is required")
  @Size(min = 10, max = 12, message = "Invalid Phone number")
  private String phone;
  @NotBlank(message = "Username is required")
  @Size(min = 12, message = "min 8 Chaarcter is required")
  private String about;
}
