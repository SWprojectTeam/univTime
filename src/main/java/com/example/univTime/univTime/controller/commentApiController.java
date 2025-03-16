package com.example.univTime.univTime.controller;

import com.example.univTime.univTime.domain.comments;
import com.example.univTime.univTime.dto.addCommentRequest;
import com.example.univTime.univTime.dto.commentResponse;
import com.example.univTime.univTime.dto.updateComment;
import com.example.univTime.univTime.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class commentApiController {
    @Autowired
    private commentService commentService;

    @GetMapping("/api/posts/{id}/comments")
    public ResponseEntity<List<commentResponse>> get(@PathVariable Long id) {
        List<commentResponse> comments = commentService.get(id);
        return comments != null ?
                ResponseEntity.status(HttpStatus.OK).body(comments):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/posts/{id}/comments")
    public ResponseEntity<comments> post(@PathVariable Long id, @RequestBody addCommentRequest request) {
        comments comments = commentService.addComment(id, request);
        return comments != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(comments):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/api/posts/{id}/comments/{commentsId}")
    public ResponseEntity<comments> edit(@PathVariable Long commentsId,
                                         @RequestBody updateComment comment) {
        comments comments = commentService.edit(commentsId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    @DeleteMapping("/api/posts/{id}/comments/{commentsId}")
    public ResponseEntity<Void> delete(@PathVariable Long commentsId) {
        commentService.delete(commentsId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
