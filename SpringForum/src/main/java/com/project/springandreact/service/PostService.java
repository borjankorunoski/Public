package com.project.springandreact.service;

import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    void addPost(Post post);
    Post getPost(Long postId);
    void deletePost(long postId);
}
