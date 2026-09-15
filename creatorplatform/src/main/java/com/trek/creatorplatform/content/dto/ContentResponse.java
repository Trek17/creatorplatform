package com.trek.creatorplatform.content.dto;

import java.time.LocalDateTime;

public class ContentResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String videoUrl;
    private final CreatorResponse creatorInfo;
    private final LocalDateTime createdAt;

    public ContentResponse(Long id, String title, String description, String videoUrl, CreatorResponse creatorInfo, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
        this.creatorInfo = creatorInfo;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public CreatorResponse getCreatorInfo() {
        return creatorInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
