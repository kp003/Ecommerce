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
    @Size(min=5,max=10,message = ">=5 and <=10 for firstname length")
    private String firstname;

    @NotBlank(message="lastname cannot be blank")
    @Size(min=5,max=10,message = ">=5 and <=10 for lasttname length")
    private String lastname;

    @NotBlank(message="email cannot be blank")
    @Email
    private String email;

    @NotBlank(message="password can not be blank")
    private String password;

}
