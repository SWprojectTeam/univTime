package com.example.univTime.univTime.dto;

import com.example.univTime.univTime.domain.post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class addPostRequest {
    private String title;
    private String content;

    public post toEntity() {
        return post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
