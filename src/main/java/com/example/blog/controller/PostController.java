package com.example.blog.controller;

import com.example.blog.entity.Post;
import com.example.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getPosts());
        return "posts";
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("prevPost", postService.getPostById(id -1));
        model.addAttribute("nextPost", postService.getPostById(id + 1));
        return "post";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }

    @PostMapping("/post")
    public String newPost(Post post, Model model) {
        if (post.getTitle().isEmpty() || post.getAuthor().isEmpty() || post.getContent().isEmpty()) {
            model.addAttribute("post", post);
            return "new-post";
        }
        postService.createPost(post);
        return "redirect:/";
    }
}
