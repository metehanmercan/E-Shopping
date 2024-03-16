package com.example.eShopping.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFavoriteProductRequest {

    @NotNull
    private int userId;

   /* @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    private String name;
*/
    @NotNull
    private int productId;

    @NotNull
    private int categoryId;
}
