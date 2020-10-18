package com.project.springandreact.service;

import com.project.springandreact.model.User;

import java.util.List;

public interface UserService{
    List<User> getAllUsers();
    void addUser(User user);
    User getUser(String username);
    User getUser(Long userId);
    void deleteUser(long userId);
    void deleteUser(String username);
}
