package com.example.univTime.univTime.controller;

import com.example.univTime.univTime.domain.post;
import com.example.univTime.univTime.dto.addPostRequest;
import com.example.univTime.univTime.dto.postResponse;
import com.example.univTime.univTime.dto.updatePost;
import com.example.univTime.univTime.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class univTimeApiController {
    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public ResponseEntity<List<post>> getArticle() {
        List<post> savedPost = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedPost);
    }

    @PostMapping("/api/posts")
    public ResponseEntity<post> addArticle(@RequestBody addPostRequest request) {
        post savedPost = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<postResponse> findById(@PathVariable Long id) {
        post findPost = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new postResponse(findPost));
    }

    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        postService.deleteId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/api/posts/{id}")
    public ResponseEntity<post> updateArticle(@PathVariable Long id,
                                              @RequestBody updatePost updatePost) {
        post post = postService.update(id, updatePost);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
