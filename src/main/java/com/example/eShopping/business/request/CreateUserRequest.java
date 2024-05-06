package com.example.eShopping.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 25)
    private String email;
    
}
