package com.project.springandreact.controllers;

import com.project.springandreact.model.User;
import com.project.springandreact.service.UserService;
import com.project.springandreact.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserService userService;
    public IndexController(){
        userService=new UserServiceImpl();
    }
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user",new User());
    }
    @GetMapping(path = "/")
    public String homeController(){
        return "index";
    }
    @PostMapping(path = "/")
    public String addUsers(@ModelAttribute("user")User user){
        userService.addUser(user);
        return "index";
    }
    @GetMapping(value = "/showlist")
    public String showUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "userinfo";
    }
}
