package com.wevioo.demo.domain.repositories;

import com.wevioo.demo.domain.aggregate.User;


public interface UserRepository {
    void create(User user);
}
