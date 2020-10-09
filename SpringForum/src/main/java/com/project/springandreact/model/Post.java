package com.project.springandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "post_date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "post_creator")
    private User creator;
}
