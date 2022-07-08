package com.springboot.pubgtracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pubgtracker.model.Match;
import com.springboot.pubgtracker.model.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String>{
	public List<Player> findByUserId(Long userId);
}
