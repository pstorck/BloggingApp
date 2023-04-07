package com.example.blog.service;

import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Post post, Comment comment) {
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
