
package com.example.privateblog.service.impl;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import com.example.privateblog.mapper.ArticleMapper;
import com.example.privateblog.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {ArticleMapper.class, ArticleServiceImpl.class})
public class ArticleServiceImplTest {


    @Autowired private ArticleServiceImpl articleService = new ArticleServiceImpl();
    @Autowired private ArticleMapper articleMapper =new ArticleMapper();

    @MockBean
    private ArticleRepository articleRepository;

    private ArticleDTO articleDTO;
    private Article article;


    @Before
    public void setUp() {
        articleDTO = new ArticleDTO();
        article = new Article();
        articleMapper.toEntity(articleDTO);
        articleDTO.setId(2L);
        articleDTO.setHeadline("test_headline");
        articleDTO.setDescription("test_sample");
        articleDTO.setAuthor("test_author");

        articleMapper.toDto(article);
        article.setId(2L);
        article.setHeadline("test_headline");
        article.setDescription("test_sample");
        article.setAuthor("test_author");
    }


    @Test
    public void findAll() {

        Article article = new Article();
        article.setId(2l);
        article.setHeadline("test_headline");
        article.setDescription("test");
        article.setAuthor("test_name");
        when(articleRepository.findAll()).thenReturn(Collections.singletonList(article));

        List<ArticleDTO> articleDTOList = articleService.findAll();

        assertNotNull(articleDTOList);
        Mockito.verify(articleRepository).findAll();
        Mockito.verifyNoMoreInteractions(articleRepository);


    }

    @Test
    public void findById() {
        when(articleRepository.findById(2l)).thenReturn(Optional.of(article));
        ArticleDTO articleDTO = null;
        try {
            articleDTO = articleService.findById(2l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(articleDTO);
        assertEquals(article.getId(), articleDTO.getId());
        Mockito.verify(articleRepository).findById(2l);
        Mockito.verifyNoMoreInteractions(articleRepository);


    }

    @Test
    public void saveArticle() {
        when(articleRepository.save(Mockito.any(Article.class))).thenReturn(article);
        ArticleDTO save = articleService.save(articleDTO);
        verify(articleRepository, times(1)).save(Mockito.any(Article.class));
        assertEquals(article.getId(), articleDTO.getId());
        Mockito.verifyNoMoreInteractions(articleRepository);

    }

    @Test
    public void updateArticle() {
        when(articleRepository.findById(2l)).thenReturn(Optional.of(article));
        when(articleRepository.save(Mockito.any(Article.class))).thenReturn(article);
        articleDTO.setId(2l);
        articleDTO.setHeadline("test_headline");
        articleDTO.setDescription("test");
        articleDTO.setAuthor("test_name");
        ArticleDTO updatedArticleDto = null;
        try {
            updatedArticleDto = articleService.updateById(2l, articleDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(updatedArticleDto);
        assertEquals(article.getId(), updatedArticleDto.getId());
        assertEquals(article.getHeadline(), updatedArticleDto.getHeadline());
        assertEquals(article.getDescription(), updatedArticleDto.getDescription());
        assertEquals(article.getAuthor(), updatedArticleDto.getAuthor());

    }

    @Test
    public void deleteById(){
        try {
            articleService.deleteById(2l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(articleRepository, times(1)).deleteById(2l);

    }
}