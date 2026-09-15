package com.trek.creatorplatform.content;

import com.trek.creatorplatform.content.dto.ContentResponse;
import com.trek.creatorplatform.content.dto.CreateContentRequest;
import com.trek.creatorplatform.content.dto.CreatorResponse;
import com.trek.creatorplatform.user.User;
import com.trek.creatorplatform.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;

    public ContentService(ContentRepository contentRepository, UserRepository userRepository) {
        this.contentRepository = contentRepository;
        this.userRepository = userRepository;
    }

    public ContentResponse createContent(CreateContentRequest request)
    {
        //hardcoding user id for mapping Content
        //to be changed when authentication implemented
        Long userId = 1L;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new InvalidUserException("User doesn't exist" ));

        Content content = new Content(
                request.getTitle(),
                request.getDescription(),
                request.getVideoUrl(),
                user
        );

        Content savedContent = contentRepository.save(content);
        CreatorResponse creatorInfo = new CreatorResponse(savedContent.getCreator().getId(),
                savedContent.getCreator().getUsername());

        return new ContentResponse(savedContent.getId(),
                savedContent.getTitle(),
                savedContent.getDescription(),
                savedContent.getVideoUrl(),
                creatorInfo,
                savedContent.getCreatedAt());
    }
}
