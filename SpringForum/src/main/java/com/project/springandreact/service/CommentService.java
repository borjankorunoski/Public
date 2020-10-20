package com.project.springandreact.service;

import com.project.springandreact.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    void addComment(Comment comment);
    void deleteComment(long commentId);
    Comment getComment(long commentId);
}
