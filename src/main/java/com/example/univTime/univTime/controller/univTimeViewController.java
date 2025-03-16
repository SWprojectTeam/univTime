package com.example.univTime.univTime.controller;

import com.example.univTime.univTime.domain.post;
import com.example.univTime.univTime.dto.commentListViewResponse;
import com.example.univTime.univTime.dto.postListViewResponse;
import com.example.univTime.univTime.dto.postViewResponse;
import com.example.univTime.univTime.service.PostService;
import com.example.univTime.univTime.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class univTimeViewController {
    @Autowired
    private PostService postService;
    @Autowired
    private commentService commentService;

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<postListViewResponse> posts = postService.getAllPosts()
                .stream()
                .map(postListViewResponse::new)
                .toList();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        post post = postService.findById(id);
        List<commentListViewResponse> comments = commentService.get(id)
                .stream()
                .map(commentListViewResponse::new)
                .toList();
        model.addAttribute("post", new postViewResponse(post));
        model.addAttribute("comments", comments);
        return "post";
    }

    @GetMapping("/edit")
    public String editPost(@RequestParam Long id, Model model) {
        post post = postService.findById(id);
        model.addAttribute("post", new postViewResponse(post));
        return "edit";
    }
}
