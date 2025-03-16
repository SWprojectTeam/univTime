package com.example.univTime.univTime.repository;

import com.example.univTime.univTime.domain.post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<post, Long> {
}
