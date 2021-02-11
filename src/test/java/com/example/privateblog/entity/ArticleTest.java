package com.example.privateblog.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {


    @Test
    public void setId() {
        Article article = new Article();
        article.setId(1l);
        assertEquals(java.util.Optional.ofNullable(1l), java.util.Optional.ofNullable(article.getId()));
    }

    @Test
    public void setHeadline() {
        Article article = new Article();
        article.setHeadline("sample");
        assertEquals("sample",article.getHeadline());
    }
    @Test
    public void setDescription() {
        Article article = new Article();
        article.setDescription("sample");
        assertEquals("sample",article.getDescription());
    }

    @Test
    public void setAuthor() {
        Article article = new Article();
        article.setAuthor("sample");
        assertEquals("sample",article.getAuthor());
    }
}