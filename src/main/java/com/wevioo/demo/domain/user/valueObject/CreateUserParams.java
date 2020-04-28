package com.wevioo.demo.domain.user.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserParams {

    private String firstName;
    private String lastName;
    private String email;
}
