package com.example.blog.service;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.repository.CommentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Post post, Comment comment) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            comment.setAuthor(auth.getName());
        }
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
