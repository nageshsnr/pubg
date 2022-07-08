package com.springboot.pubgtracker.service;

import com.springboot.pubgtracker.model.User;
import com.springboot.pubgtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUser() {
        return userRepository.findAll();
    }
    public User findById(long id) {
        return userRepository.findById(id).get();
    }
    public User update(User user, long l) {
        return userRepository.save(user);
    }
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User validateUser(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }
}
