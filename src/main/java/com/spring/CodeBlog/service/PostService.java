package com.spring.CodeBlog.service;

import com.spring.CodeBlog.Repository.PostRepository;
import com.spring.CodeBlog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    List<Post> findAll() {
    return postRepository.findAll();
    };

    Post findById(long id) {
    return postRepository.findById(id).get();
    };

    Post save(Post post) {
    return postRepository.save(post);
    };
}
