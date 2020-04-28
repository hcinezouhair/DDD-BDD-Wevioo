package com.wevioo.demo.infrastructure.createUser.io;

import com.wevioo.demo.domain.user.valueObject.CreateUserParams;
import org.springframework.stereotype.Component;

@Component
public class CreateUSerMapper {
    public CreateUserParams toCreateParams(CreateUSerRequest createUSerRequest) {
        return new CreateUserParams(createUSerRequest.getFirstName(), createUSerRequest.getLastName(), createUSerRequest.getEmail());
    }
}
