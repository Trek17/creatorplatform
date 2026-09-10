package com.trek.creatorplatform.content.controller;

import com.trek.creatorplatform.content.ContentService;
import com.trek.creatorplatform.content.dto.ContentResponse;
import com.trek.creatorplatform.content.dto.CreateContentRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping
    public ContentResponse createContent(@Valid @RequestBody CreateContentRequest request)
    {
        return contentService.createContent(request);
    }
}
