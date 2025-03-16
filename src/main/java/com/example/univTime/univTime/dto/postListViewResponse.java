package com.example.univTime.univTime.dto;

import com.example.univTime.univTime.domain.post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class postListViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;

    public postListViewResponse(post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.created_at = post.getCreatedAt();
    }
}
