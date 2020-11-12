package com.project.springandreact.config;

import com.project.springandreact.model.Comment;
import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

@Configuration
public class BeanConfig {
    @Bean
    @ApplicationScope
    public User user(){
        return new User();
    }
    @Bean
    @ApplicationScope
    public Post post(){
        return new Post();
    }
    @Bean
    @ApplicationScope
    public Comment comment(){
        return new Comment();
    }
}
