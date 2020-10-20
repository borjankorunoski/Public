package com.project.springandreact.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User{//046252022
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_enabled")
    private boolean enabled = true;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_surname")
    private String surname;
    @Column(name = "user_age")
    private int age;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_username")
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_role")
    private String role;
    @JsonManagedReference(value = "user_posts_json")
    @Column(name = "user_posts")
    @OneToMany(mappedBy = "creator")
    private List<Post> postList;
    @JsonManagedReference(value = "user_comments_json")
    @Column(name = "user_comments")
    @OneToMany(mappedBy = "commentator")
    private List<Comment> commentList;
}
