package com.example.pafbackend.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;



@Data
@Document(collection = "accounts")
public class Account {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
  @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,20}$",
        message = "Password must contain at least one letter and one number"
    )
    private String password;
    @CreatedDate
    private LocalDate createdDate;
}