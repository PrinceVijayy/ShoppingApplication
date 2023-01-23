package com.ojas.Shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {


    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String email;

    private String phoneNumber;

    private String address;

    private String password;
}
