package com.example.eShopping;

import com.example.eShopping.core.utilities.exceptions.BusinessException;
import com.example.eShopping.core.utilities.exceptions.EmptyResultDataAccessExceptionnn;
import com.example.eShopping.core.utilities.exceptions.ProblemDetails;
import com.example.eShopping.core.utilities.exceptions.SuchElementException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@SpringBootApplication
@RestControllerAdvice
public class EShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EShoppingApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleProblemDetails(BusinessException businessException) {
        ProblemDetails problemDetails=new ProblemDetails();

       problemDetails.setMessage(businessException.getMessage());
        return  problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleProblemDetails(NoSuchElementException noSuchElementException) {
        SuchElementException suchElementException=new SuchElementException();
        suchElementException.setMessage("category does not exist");
        return  suchElementException;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleProblemDetails(EmptyResultDataAccessException emptyResultDataAccessException) {
        EmptyResultDataAccessExceptionnn emptyResultDataAccessExceptionnn=new EmptyResultDataAccessExceptionnn();
        emptyResultDataAccessExceptionnn.setMessage("No class com.example.eShopping.entities.concretes.Category entity with id 8 exists!");
       return emptyResultDataAccessExceptionnn;
    }

}


