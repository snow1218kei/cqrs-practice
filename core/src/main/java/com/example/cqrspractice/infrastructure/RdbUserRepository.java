package com.example.cqrspractice.infrastructure;

import com.example.cqrspractice.domain.UserRepository;
import com.example.cqrspractice.infrastructure.orm.UserOrm;

public class RdbUserRepository implements UserRepository {
    private final UserOrm userOrm;

    public RdbUserRepository(UserOrm orm) {
        this.userOrm = orm;
    }

    @Override
    public User findByEmail(String email) {
        return userOrm.findByEmail(email);
    }

    @Override
    public void save(User user) {

    }
}
