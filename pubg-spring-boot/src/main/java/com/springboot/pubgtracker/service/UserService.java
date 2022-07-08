package com.springboot.pubgtracker.service;

import com.springboot.pubgtracker.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);
    public List<User> getUser();
    public User findById(long id);
    public User update(User user, long id);
    public void deleteUserById(long id);
    public User validateUser(String emailAddress);
}
