package com.springboot.pubgtracker.repository;

import com.springboot.pubgtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmailAddress(String emailAddress);
}
