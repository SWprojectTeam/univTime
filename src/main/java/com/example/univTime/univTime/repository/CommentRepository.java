package com.example.univTime.univTime.repository;

import com.example.univTime.univTime.domain.comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<comments, Long> {
    List<comments> findByPostId(Long postId);
    List<comments> findByName(String name);
    @Transactional
    @Modifying
    @Query("DELETE FROM comments c WHERE c.post.id = :postId")
    void deleteByPostId(@Param("postId") Long postId);
}
