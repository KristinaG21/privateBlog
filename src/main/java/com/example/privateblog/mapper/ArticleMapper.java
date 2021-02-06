package com.example.privateblog.mapper;


import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public Article toEntity(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setHeadline(articleDTO.getHeadline());
        article.setBody(articleDTO.getBody());
        article.setAuthor(articleDTO.getAuthor());
        article.setLocalDate(articleDTO.getLocalDate());
        return article;
    }

    public ArticleDTO toDto(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setHeadline(article.getHeadline());
        articleDTO.setBody(article.getBody());
        articleDTO.setAuthor(article.getAuthor());
        articleDTO.setLocalDate(article.getLocalDate());
        return articleDTO;
    }
}
