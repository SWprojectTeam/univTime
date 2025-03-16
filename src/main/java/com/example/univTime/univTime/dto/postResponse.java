package com.example.univTime.univTime.dto;

import com.example.univTime.univTime.domain.post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class postResponse {
    private String title;
    private String content;

    public postResponse(post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
