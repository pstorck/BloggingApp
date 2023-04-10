package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("{postId}")
    public String addComment(@PathVariable Integer postId, @Valid Comment comment, BindingResult result, Model model) {
        Post post = postService.getPostById(postId);
        if (result.hasErrors()) {
            model.addAttribute("comment", comment);
            model.addAttribute("post", post);
            return "post";
        }
        commentService.addComment(post, comment);
        return "redirect:/" + postId;
    }
}
