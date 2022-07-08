package com.springboot.pubgtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pubgtracker.model.Player;
import com.springboot.pubgtracker.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
    PlayerRepository playerRepository;

	@Override
	public void createPlayer(Player player) {
		// TODO Auto-generated method stub
		playerRepository.save(player);
	}

	@Override
	public void deletePlayer(String playerId) {
		// TODO Auto-generated method stub
		 playerRepository.deleteById(playerId);
	}

	@Override
	public List<Player> getFavouritePlayers(Long userId) {
		// TODO Auto-generated method stub
		return playerRepository.findByUserId(userId);
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return playerRepository.findAll();
	}
	
}
