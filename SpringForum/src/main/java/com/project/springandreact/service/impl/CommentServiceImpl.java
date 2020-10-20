package com.project.springandreact.service.impl;

import com.project.springandreact.model.Comment;
import com.project.springandreact.repository.CommentRepository;
import com.project.springandreact.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment getComment(long commentId) {
        return commentRepository.findById(commentId).orElse(new Comment());
    }
}
