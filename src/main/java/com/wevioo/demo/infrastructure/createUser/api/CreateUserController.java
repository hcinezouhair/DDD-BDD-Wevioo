package com.wevioo.demo.infrastructure.createUser.api;

import com.wevioo.demo.domain.user.CreateUser;
import com.wevioo.demo.domain.user.valueObject.CreateUserParams;
import com.wevioo.demo.infrastructure.createUser.io.CreateUSerChecker;
import com.wevioo.demo.infrastructure.createUser.io.CreateUSerMapper;
import com.wevioo.demo.infrastructure.createUser.io.CreateUSerRequest;
import com.wevioo.demo.infrastructure.utils.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/")
@Api(value = "Manages users operations", tags = "User")
public class CreateUserController {


    @Autowired
    private CreateUSerChecker createUSerChecker;
    @Autowired
    private CreateUSerMapper createUSerMapper;
    @Autowired
    private CreateUser createUSer;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(propagation = Propagation.REQUIRED)
    @ApiOperation(value = "Creates users")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class)})
    public void create(@NonNull @RequestBody CreateUSerRequest adminEditRequest) {
        createUSerChecker.check(adminEditRequest);
        CreateUserParams createUSerParams = createUSerMapper.toCreateParams(adminEditRequest);
        createUSer.create(createUSerParams);
    }
}
