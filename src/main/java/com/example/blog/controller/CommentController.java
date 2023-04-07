package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addComment(@PathVariable Integer postId, Comment comment, Model model) {
        if (comment.getAuthor().isEmpty() || comment.getContent().isEmpty()) {
            model.addAttribute("comment", comment);
        } else {
            commentService.addComment(postService.getPostById(postId), comment);
        }
        return "redirect:/" + postId;
    }
}
