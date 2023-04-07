package com.example.blog.controller;

import com.example.blog.entity.Post;
import com.example.blog.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostRestController {
    private PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }
}
