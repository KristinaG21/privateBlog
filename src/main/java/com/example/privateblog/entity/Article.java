package com.example.privateblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;

@Data
@Entity
@Table(name="ARTICLES" )
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="headline")
    private String headline;


    @Column(name="description")
    private String description;


    @Column(name="author")
    private String author;

}
