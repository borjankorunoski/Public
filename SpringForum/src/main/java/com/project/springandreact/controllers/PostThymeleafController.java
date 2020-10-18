package com.project.springandreact.controllers;

import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;
import com.project.springandreact.service.PostService;
import com.project.springandreact.service.UserService;
import com.project.springandreact.service.impl.PostServiceImpl;
import com.project.springandreact.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/*@Controller
@RequestMapping("/user")
public class PostThymeleafController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    public PostThymeleafController(){
        userService = new UserServiceImpl();
        postService = new PostServiceImpl();
    }
    @GetMapping("/newpost")
    public String seeNew(Model model) {
        model.addAttribute("post", new Post());
        return "new";
    }

    @PostMapping("/newpost")
    public String addPost(@ModelAttribute("post") Post post) {
        Post tmp = post;
        User creator = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        tmp.setCreator(creator);
        tmp.setDateTime(LocalDateTime.now());
        postService.addPost(tmp);
        return "new";
    }
}*/
