package org.felipecpdev.redisspringdemo2.service;

import org.felipecpdev.redisspringdemo2.models.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String id);

    List<User> getAllUsers();

    User updateUser(User user,String id);

    void deleteUser(String id);
}
