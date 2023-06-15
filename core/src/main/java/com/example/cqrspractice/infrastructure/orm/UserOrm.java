package com.example.cqrspractice.infrastructure.orm;

import com.example.cqrspractice.infrastructure.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrm extends JpaRepository<User, Long>{
    User findByEmail(String email);
}

