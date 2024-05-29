package org.felipecpdev.redisspringdemo2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.felipecpdev.redisspringdemo2.exceptions.UserNotFoundException;
import org.felipecpdev.redisspringdemo2.models.User;
import org.felipecpdev.redisspringdemo2.repositories.UserRepository;
import org.felipecpdev.redisspringdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


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
    public User getUser(String id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user, String id) throws UserNotFoundException {
        User userFound = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userFound.setName(user.getName());
        userFound.setTtl(defaultTtl);
        return userRepository.save(userFound);
    }

    @Override
    public void deleteUser(String id) throws UserNotFoundException {
        User userFound = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepository.delete(userFound);
    }
}
