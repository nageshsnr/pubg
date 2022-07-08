package com.springboot.pubgtracker.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "match")
public class Match {
    @Id
    private String id;
    private String createdAt;
    private Long userId;

	public Match(String id, String createdAt, Long userId) {
		this.id = id;
		this.createdAt = createdAt;
		this.userId = userId;
	}

	public Match() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Match{" +
				"id='" + id + '\'' +
				", createdAt='" + createdAt + '\'' +
				", userId=" + userId +
				'}';
	}
}
