package com.example.univTime.univTime.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class commentListViewResponse {
    private String nickname;
    private String body;

    public commentListViewResponse(commentResponse response) {
        this.nickname = response.getNickname();
        this.body = response.getBody();
    }
}
