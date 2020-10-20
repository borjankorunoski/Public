package com.project.springandreact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "comments_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private long id;
    @Column(name = "comment_content")
    private String content;
    @Column(name = "comment_date_time")
    private LocalDateTime dateTime;
    @JsonBackReference(value = "user_comments_json")
    @ManyToOne @JoinColumn(name = "comment_writer")
    private User commentator;
    @JsonBackReference(value = "post_comments")
    @ManyToOne @JoinColumn(name = "comment_to_post")
    private Post postCommentedOn;
}
