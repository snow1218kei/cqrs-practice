package com.example.cqrspractice.domain;

import com.example.cqrspractice.infrastructure.User;

public interface UserRepository {
    User findByEmail(String email);

    void save(User user);
}
