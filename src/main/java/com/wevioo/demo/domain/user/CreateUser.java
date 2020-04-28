package com.wevioo.demo.domain.user;

import com.wevioo.demo.domain.aggregate.User;
import com.wevioo.demo.domain.exception.BusinessException;
import com.wevioo.demo.domain.repositories.UserRepository;
import com.wevioo.demo.domain.user.valueObject.CreateUserParams;
import com.wevioo.demo.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.wevioo.demo.domain.exception.BusinessExceptionCode.INVALID_PROFESSIONAL_EMAIL;

@Service
public class CreateUser {

    public static final String WEVIOO_COM = "@wevioo.com";
    @Autowired
    private UserRepository userRepository;

    public void create(CreateUserParams createUserParams) {
        if(!createUserParams.getEmail().endsWith(WEVIOO_COM)) {
            throw new BusinessException("Invalid professional email", INVALID_PROFESSIONAL_EMAIL);
        }
        User user = new User(createUserParams.getFirstName(), createUserParams.getLastName(), createUserParams.getEmail());
        userRepository.create(user);

    }
}
