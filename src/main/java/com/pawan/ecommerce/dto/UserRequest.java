package com.pawan.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


    @NotBlank(message="firstname cannot be blank")
    @Size(min=3,max=20,message = "first name should be greater than 3 letters and less than 20")
    private String firstname;

    @NotBlank(message="lastname cannot be blank")
    @Size(min=2,max=20,message = "last name should be greater than 3 letters and less than 20")
    private String lastname;

    @NotBlank(message="email cannot be blank")
    @Email
    private String email;

    @NotBlank(message="password can not be blank")
    private String password;

}
