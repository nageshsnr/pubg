package com.springboot.pubgtracker.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "player")
public class Player {
	@Id
    private String id;
	private String name;
	private String kills;
	private String matchId;
	private Long userId;

	public Player() {
	}

	public Player(String id, String name, String kills, String matchId, Long userId) {
		this.id = id;
		this.name = name;
		this.kills = kills;
		this.matchId = matchId;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKills() {
		return kills;
	}

	public void setKills(String kills) {
		this.kills = kills;
	}

	@Override
	public String toString() {
		return "Player{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", kills='" + kills + '\'' +
				", matchId='" + matchId + '\'' +
				", userId=" + userId +
				'}';
	}
}
