package com.example.blog.service;

import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.transformer.ContentTransformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private ContentTransformer contentTransformer;

    public PostService(PostRepository postRepository, ContentTransformer contentTransformer) {
        this.postRepository = postRepository;
        this.contentTransformer = contentTransformer;
    }

    public void createPost(Post post) {
        post.setContent(contentTransformer.transform(post.getContent()));
        postRepository.save(post);
    }

    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }
}
