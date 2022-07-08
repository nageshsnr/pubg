package com.springboot.pubgtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.pubgtracker.model.Match;
import com.springboot.pubgtracker.model.Player;
import com.springboot.pubgtracker.service.MatchService;
import com.springboot.pubgtracker.service.PlayerService;

@CrossOrigin
@RestController
public class PlayerController {
	@Autowired
    PlayerService playerService;


    @PostMapping("/addPlayer")
    String  createPlayer(@RequestBody Player player){
        playerService.createPlayer(player);
        return "Player added successfully";
    }

    @DeleteMapping("/deletePlayer/{id}")
    String deletePlayer(@PathVariable("id") String playerId){
    	playerService.deletePlayer(playerId);
        return "Player deleted successfully";
    }

    @GetMapping("/getFavPlayers/{id}")
    List<Player> getPlayer(@PathVariable("id") Long userId){
        return playerService.getFavouritePlayers(userId);
    }

    @GetMapping("/getGlobalPlayers")
    List<Player> getPlayers(){
        return playerService.getPlayers();
    }
}
