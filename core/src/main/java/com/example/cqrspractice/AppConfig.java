package com.example.cqrspractice;

import com.example.cqrspractice.domain.UserRepository;
import com.example.cqrspractice.infrastructure.RdbUserRepository;
import com.example.cqrspractice.infrastructure.orm.UserOrm;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public UserRepository userRepository(UserOrm userOrm) {
        return new RdbUserRepository(userOrm);
    }
}
