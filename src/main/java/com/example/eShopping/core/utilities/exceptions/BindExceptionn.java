package com.example.eShopping.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class BindExceptionn extends ProblemDetails{
    private Map<String,String> error;
}
