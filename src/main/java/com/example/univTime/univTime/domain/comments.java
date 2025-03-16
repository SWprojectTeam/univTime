package com.example.univTime.univTime.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "postId")
    private post post;
    @Column
    private String name;
    @Column
    private String body;

    @Builder
    public comments(post post, String name, String body) {
        this.post = post;
        this.name = name;
        this.body = body;
    }

    public void update(String body) {
        this.body = body;
    }
}
