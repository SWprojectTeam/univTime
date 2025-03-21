package com.example.univTime.univTime.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false, updatable = false)
    private String password;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Builder
    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
