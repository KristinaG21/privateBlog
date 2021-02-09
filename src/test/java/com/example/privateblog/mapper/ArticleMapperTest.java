package com.example.privateblog.mapper;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper= new ArticleMapper();

    @Test
    void toEntity() {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = articleMapper.toEntity(articleDTO);
        Assert.assertEquals(article.getId(),articleDTO.getId());
        Assert.assertEquals(article.getHeadline(),articleDTO.getHeadline());
        Assert.assertEquals(article.getDescription(),articleDTO.getDescription());
        Assert.assertEquals(article.getAuthor(),articleDTO.getAuthor());



    }

    @Test
    void toDto() {
        Article article = new Article();
        ArticleDTO articleDTO = articleMapper.toDto(article);
        Assert.assertEquals(articleDTO.getId(),article.getId());
        Assert.assertEquals(articleDTO.getHeadline(),article.getHeadline());
        Assert.assertEquals(articleDTO.getDescription(),article.getDescription());
        Assert.assertEquals(articleDTO.getAuthor(),article.getAuthor());

    }
}