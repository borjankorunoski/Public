package com.project.springandreact.service.impl;

import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;
import com.project.springandreact.repository.PostRepository;
import com.project.springandreact.service.PostService;
import com.project.springandreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(Long postId) {
        Post tmp = postRepository.findById(postId).orElse(new Post());
        return tmp;
    }

    @Override
    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }
}
