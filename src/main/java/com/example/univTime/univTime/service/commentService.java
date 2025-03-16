package com.example.univTime.univTime.service;

import com.example.univTime.univTime.domain.comments;
import com.example.univTime.univTime.domain.post;
import com.example.univTime.univTime.dto.addCommentRequest;
import com.example.univTime.univTime.dto.commentResponse;
import com.example.univTime.univTime.dto.updateComment;
import com.example.univTime.univTime.repository.CommentRepository;
import com.example.univTime.univTime.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class commentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<commentResponse> get(Long id) {
        List<comments> commentsList = commentRepository.findByPostId(id);
        return commentsList.stream()
                .map(commentResponse::new)
                .toList();
    }
    public comments addComment(Long id, addCommentRequest request) {
        post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No post"));
        comments comments = com.example.univTime.univTime.domain.comments.builder()
                .post(post)
                .name(request.getNickname())
                .body(request.getBody())
                .build();
        commentRepository.save(comments);
        return comments;
    }
    public comments edit(Long id, updateComment comment) {
        comments comments = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Comments"));
        comments.update(comment.getBody());
        commentRepository.save(comments);
        return comments;
    }
    @Transactional
    public void delete(Long commentId) {
        comments comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("No comment"));
        commentRepository.delete(comment);
    }
}
