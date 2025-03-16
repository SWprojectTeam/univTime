package com.example.univTime.univTime.service;

import com.example.univTime.univTime.domain.post;
import com.example.univTime.univTime.dto.addPostRequest;
import com.example.univTime.univTime.dto.updatePost;
import com.example.univTime.univTime.repository.CommentRepository;
import com.example.univTime.univTime.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    public List<post> getAllPosts() {
        return postRepository.findAll();
    }

    public post findById(@PathVariable Long id) {
        return postRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("No Post"));
    }

    public post save(addPostRequest request) {
        return postRepository.save(request.toEntity());
    }

    public void deleteId(Long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }
    @Transactional
    public post update(Long id, updatePost updatePost) {
        post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        post.update(updatePost.getTitle(), updatePost.getContent());
        return post;
    }
}
