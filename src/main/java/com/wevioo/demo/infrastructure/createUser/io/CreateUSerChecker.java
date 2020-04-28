package com.wevioo.demo.infrastructure.createUser.io;

import com.wevioo.demo.infrastructure.exception.BadDataArgumentException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.wevioo.demo.infrastructure.exception.BadDataArgumentExceptionCode.*;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class CreateUSerChecker {

    public void check(CreateUSerRequest createUSerRequest) {

        String regexEmail = "^(.+)@(.+)$";
        String regexName = "[A-Za-z]+";

        if (isEmpty(createUSerRequest.getEmail())) {
            throw new BadDataArgumentException("email can't be empty", BAD_EMAIL);
        }
        if (!Pattern.compile(regexEmail).matcher(createUSerRequest.getEmail()).matches()) {
            throw new BadDataArgumentException("bad email format", BAD_EMAIL);
        }
        if (isEmpty(createUSerRequest.getFirstName())) {
            throw new BadDataArgumentException("first name can't be empty", BAD_FIRST_NAME);
        }
        if (!Pattern.compile(regexName).matcher(createUSerRequest.getFirstName()).matches()) {
            throw new BadDataArgumentException("bad first name format", BAD_FIRST_NAME);
        }
        if (isEmpty(createUSerRequest.getLastName())) {
            throw new BadDataArgumentException("last name can't be empty", BAD_LAST_NAME);
        }
        if (!Pattern.compile(regexName).matcher(createUSerRequest.getLastName()).matches()) {
            throw new BadDataArgumentException("bad last name format", BAD_LAST_NAME);
        }
    }
}
