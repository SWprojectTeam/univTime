package com.example.univTime.univTime.dto;

import com.example.univTime.univTime.domain.comments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class commentResponse {
    private Long id;
    private Long postId;
    private String nickname;
    private String body;

    public commentResponse(comments comments) {
        this.id = comments.getId();
        this.postId = comments.getPost().getId();
        this.nickname = comments.getName();
        this.body = comments.getBody();
    }
}
