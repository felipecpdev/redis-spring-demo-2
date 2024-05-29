package org.felipecpdev.redisspringdemo2.service;

import org.felipecpdev.redisspringdemo2.exceptions.UserNotFoundException;
import org.felipecpdev.redisspringdemo2.models.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String id) throws UserNotFoundException;

    List<User> getAllUsers();

    User updateUser(User user,String id) throws UserNotFoundException;

    void deleteUser(String id) throws UserNotFoundException;
}
