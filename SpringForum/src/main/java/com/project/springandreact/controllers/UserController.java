package com.project.springandreact.controllers;

import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;
import com.project.springandreact.service.CommentService;
import com.project.springandreact.service.PostService;
import com.project.springandreact.service.UserService;
import com.project.springandreact.service.impl.CommentServiceImpl;
import com.project.springandreact.service.impl.PostServiceImpl;
import com.project.springandreact.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    PostService postService;
    @Autowired
    public void setUserService(UserServiceImpl userService){
        this.userService=userService;
    }
    @Autowired
    public void setUserService(PostServiceImpl postService){
        this.postService=postService;
    }
    @GetMapping("/profile")
    public User me(){
        String client = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUser(client);
    }
    @PatchMapping(value = "/updateprofile", consumes = "application/json", produces = "application/json")
    public String updateProfile(@RequestBody User user){
        String me = SecurityContextHolder.getContext().getAuthentication().getName();
        User tmp = userService.getUser(me);
        if(user.getName()!=null){
            tmp.setName(user.getName());
        }
        if(user.getSurname()!=null){
            tmp.setSurname(user.getSurname());
        }
        if(user.getEmail()!=null){
            tmp.setEmail(user.getEmail());
        }
        if(user.getAge()!=0){
            tmp.setAge(user.getAge());
        }
        if(user.getPassword()!=null){
            tmp.setPassword(user.getPassword());
        }
        userService.addUser(tmp);
        return String.valueOf((userService.getUser(tmp.getUsername())).getId());
    }


}
