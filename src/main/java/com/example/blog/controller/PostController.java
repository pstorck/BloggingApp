package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String getPosts(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("posts", postService.getPosts());
        return "posts";
    }

    @GetMapping("{id}")
    public String getPost(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("prevPost", postService.getPostById(id -1));
        model.addAttribute("nextPost", postService.getPostById(id + 1));
        model.addAttribute("comment", new Comment());
        return "post";
    }

    @GetMapping("new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }

    @PostMapping("new")
    public String newPost(@Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", post);
            return "new-post";
        }
        postService.createPost(post);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editPost(@PathVariable int id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "new-post";
    }

    @PostMapping("edit/{id}")
    public String editPost(@PathVariable int id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", post);
            return "new-post";
        }
        postService.updatePost(id, post);
        return "redirect:/";
    }

    @PostMapping("delete/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
