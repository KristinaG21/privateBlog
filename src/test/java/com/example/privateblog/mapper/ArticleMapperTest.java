package com.example.privateblog.mapper;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper= new ArticleMapper();

    @Test
    void toEntity() {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = articleMapper.toEntity(articleDTO);
        assertEquals(article.getId(),articleDTO.getId());
        assertEquals(article.getHeadline(),articleDTO.getHeadline());
        assertEquals(article.getDescription(),articleDTO.getDescription());
        assertEquals(article.getAuthor(),articleDTO.getAuthor());



    }

    @Test
    void toDto() {
        Article article = new Article();
        ArticleDTO articleDTO = articleMapper.toDto(article);
        assertEquals(articleDTO.getId(),article.getId());
        assertEquals(articleDTO.getHeadline(),article.getHeadline());
        assertEquals(articleDTO.getDescription(),article.getDescription());
        assertEquals(articleDTO.getAuthor(),article.getAuthor());

    }
}