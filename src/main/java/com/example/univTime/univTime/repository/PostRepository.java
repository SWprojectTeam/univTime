package com.example.univTime.univTime.repository;

import com.example.univTime.univTime.domain.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PostRepository extends JpaRepository<post, Long> {
    // 제목에 특정 단어를 포함하는 게시글 찾기
    List<post> findByTitleContaining(String keyword);
}
