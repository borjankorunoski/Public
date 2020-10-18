package com.project.springandreact.controllers;

import com.project.springandreact.model.Post;
import com.project.springandreact.model.User;
import com.project.springandreact.service.PostService;
import com.project.springandreact.service.UserService;
import com.project.springandreact.service.impl.PostServiceImpl;
import com.project.springandreact.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    public AdminController(){
        userService= new UserServiceImpl();
        postService = new PostServiceImpl();
    }
    @GetMapping(value = "/user/{id}", produces = "application/json")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    @GetMapping(value = "/allusers", produces = "application/json")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping(value = "/adduser", consumes = "application/json", produces = "application/json")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return String.valueOf((userService.getUser(user.getUsername())).getId());
    }
    @PatchMapping(value = "/editprofile/{id}", consumes = "application/json", produces = "application/json")
    public String editProfile(@RequestBody User user, @PathVariable("id")long id){
        User tmp = userService.getUser(id);
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
        if(user.getUsername()!=null){
            tmp.setUsername(user.getUsername());
        }
        if(user.getPassword()!=null){
            tmp.setPassword(user.getPassword());
        }
        if(user.getRole()!=null){
            tmp.setRole(user.getRole());
        }
        if(!user.isEnabled()){
            tmp.setEnabled(user.isEnabled());
        }

        userService.addUser(tmp);
        return String.valueOf((userService.getUser(tmp.getUsername())).getId());
    }
    @DeleteMapping(value = "/deleteuser/{id}")
    public void deleteUser(@PathVariable("id")long id){
        userService.deleteUser(id);
    }

    @GetMapping(value = "/post/{id}", produces = "application/json")
    public Post getPost(@PathVariable("id") Long id){
        return postService.getPost(id);
    }
    @GetMapping(value = "/allposts", produces = "application/json")
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }
    @PostMapping(value = "/addpost", consumes = "application/json", produces = "application/json")
    public String addPost(@RequestBody Post post){
        Post tmp = post;
        User creator = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        tmp.setCreator(creator);
        tmp.setDateTime(LocalDateTime.now());
        postService.addPost(tmp);
        return String.valueOf((postService.getPost(post.getId())).getId());
    }
    @DeleteMapping(value = "/deletepost/{id}")
    public void deletePost(@PathVariable("id")long id){
        postService.deletePost(id);
    }

}