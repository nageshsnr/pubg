package com.springboot.pubgtracker.service;

import com.springboot.pubgtracker.model.Match;
import com.springboot.pubgtracker.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Override
    public void createMatch(Match match) {
        matchRepository.save(match);
    }

    @Override
    public List<Match> getFavouriteMatch(Long userId) {
        return matchRepository.findByUserId(userId);
    }

    @Override
    public void deleteMatch(String matchId) {
        Match match = matchRepository.findById(matchId).get();
        System.out.println("match = " + match);
        matchRepository.delete(match);
    }

}
