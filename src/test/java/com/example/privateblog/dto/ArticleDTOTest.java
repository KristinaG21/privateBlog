package com.example.privateblog.dto;

import com.example.privateblog.entity.Article;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleDTOTest {

    @Test
    public void setId() {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(1l);
        assertEquals(java.util.Optional.ofNullable(1l), java.util.Optional.ofNullable(articleDTO.getId()));
    }

    @Test
    public void setHeadline() {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setHeadline("sample");
        assertEquals("sample",articleDTO.getHeadline());
    }
    @Test
    public void setDescription() {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setDescription("sample");
        assertEquals("sample",articleDTO.getDescription());
    }

    @Test
    public void setAuthor() {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setAuthor("sample");
        assertEquals("sample",articleDTO.getAuthor());
    }
}