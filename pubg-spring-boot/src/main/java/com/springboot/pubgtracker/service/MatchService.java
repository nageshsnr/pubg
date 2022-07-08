package com.springboot.pubgtracker.service;

import com.springboot.pubgtracker.model.Match;
import com.springboot.pubgtracker.model.User;

import java.util.List;

public interface MatchService {
    void createMatch(Match match);
    List<Match> getFavouriteMatch(Long userId);
    void deleteMatch(String id);
}
