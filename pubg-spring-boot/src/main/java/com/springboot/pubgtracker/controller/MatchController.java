package com.springboot.pubgtracker.controller;

import com.springboot.pubgtracker.model.Match;
import com.springboot.pubgtracker.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MatchController {

    @Autowired
    MatchService matchService;


    @PostMapping("/addFav")
    String createMatch(@RequestBody Match match){
        matchService.createMatch(match);
        return "Match added successfully";
    }

    @DeleteMapping("/deleteFav/{id}")
    String deleteMatch(@PathVariable("id") String matchId){
        System.out.println("matchId = " + matchId);
        matchService.deleteMatch(matchId);
        return "Match deleted successfully";
    }

    @GetMapping("/favMatch/{id}")
    List<Match> getAllMatch(@PathVariable("id") Long userId){
        return matchService.getFavouriteMatch(userId);
    }
}
