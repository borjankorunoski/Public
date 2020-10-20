package com.project.springandreact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id")
    private long id;
    @Column(name = "post_title")
    private String title;
    @Column(name = "post_paragraph")
    private String paragraph;
    @Column(name = "post_date_time")
    private LocalDateTime dateTime;
    @JsonBackReference(value = "user_posts_json")
    @ManyToOne
    @JoinColumn(name = "post_creator")
    private User creator;
    @JsonManagedReference(value = "post_comments")
    @OneToMany(mappedBy = "postCommentedOn")
    @Column(name = "post_replies")
    List<Comment> postReplies;
}
