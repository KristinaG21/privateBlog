package com.example.privateblog.mapper;


import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public Article toEntity(ArticleDTO articleDTO) {
        Article article = new Article();
        article.setHeadline(articleDTO.getHeadline());
        article.setDescription(articleDTO.getDescription());
        article.setAuthor(articleDTO.getAuthor());
        return article;
    }

    public ArticleDTO toDto(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setHeadline(article.getHeadline());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setAuthor(article.getAuthor());
        return articleDTO;
    }
}
