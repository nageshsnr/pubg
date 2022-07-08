package com.springboot.pubgtracker.repository;

import com.springboot.pubgtracker.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends MongoRepository<Match,String> {
    public List<Match> findByUserId(Long userId);

}
