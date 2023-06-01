package com.example.cqrspractice.application;

import com.example.cqrspractice.domain.UserEntity;
import com.example.cqrspractice.domain.UserRepository;
import com.example.cqrspractice.infrastructure.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity updatePassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }

        UserEntity userEntity = toDomainModel(user);
        userEntity.setPassword(newPassword);
        user.setPassword(userEntity.getPassword());
        userRepository.save(user);

        return userEntity;
    }

    private UserEntity toDomainModel(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
