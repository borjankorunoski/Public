package com.project.springandreact.repository;

import com.project.springandreact.model.Comment;
import com.project.springandreact.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}