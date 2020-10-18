package com.project.springandreact.controllers;

import antlr.StringUtils;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    public IndexController(){
        userService= new UserServiceImpl();
        postService = new PostServiceImpl();
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user",new User());
    }
    @GetMapping(path = "/")
    public String homeController(Model model){
        return "index";
    }
    @PostMapping(path = "/")
    public String addUsers(@ModelAttribute("user")User user){
        userService.addUser(user);
        return "index";
    }

}
