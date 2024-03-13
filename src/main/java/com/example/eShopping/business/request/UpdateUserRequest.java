package com.example.eShopping.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateUserRequest {
    @NotNull
    private int id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 21)
    private String name;

    @NotNull
    @Size(min = 3, max = 21)
    @NotBlank
    private String email;
}
