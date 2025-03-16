package com.example.univTime.univTime.dto;

import com.example.univTime.univTime.domain.post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class postViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;

    public postViewResponse(post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.created_at = post.getCreatedAt();
    }
}
