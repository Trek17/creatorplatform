package com.trek.creatorplatform.content.dto;

public class CreatorResponse {
    private final Long id;
    private final String username;

    public CreatorResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}
