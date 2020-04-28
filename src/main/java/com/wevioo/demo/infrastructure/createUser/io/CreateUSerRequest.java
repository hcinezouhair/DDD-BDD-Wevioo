package com.wevioo.demo.infrastructure.createUser.io;

import lombok.Data;

@Data
public class CreateUSerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String sexe;

    public CreateUSerRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
