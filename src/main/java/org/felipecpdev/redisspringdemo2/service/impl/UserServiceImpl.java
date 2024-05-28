package org.felipecpdev.redisspringdemo2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.felipecpdev.redisspringdemo2.models.User;
import org.felipecpdev.redisspringdemo2.repositories.UserRepository;
import org.felipecpdev.redisspringdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Value("${spring.cache.redis.time-to-live}")
    private Long defaultTtl;

    @Override
    public User saveUser(User user) {
        user.setUuid(UUID.randomUUID().toString());
        user.setTtl(defaultTtl);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String id) {
        User userFound = userRepository.findById(id).orElseThrow();
        userFound.setName(user.getName());
        userFound.setTtl(defaultTtl);
        return userRepository.save(userFound);
    }

    @Override
    public void deleteUser(String id) {
        User userFound = userRepository.findById(id).orElseThrow();
        userRepository.delete(userFound);
    }
}
