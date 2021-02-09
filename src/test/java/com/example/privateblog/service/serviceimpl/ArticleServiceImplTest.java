package com.example.privateblog.service.serviceimpl;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import com.example.privateblog.exception.ArticleNotFoundException;
import com.example.privateblog.mapper.ArticleMapper;
import com.example.privateblog.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

  @InjectMocks
  private ArticleServiceImpl articleService = new ArticleServiceImpl();

  @Mock
    private ArticleRepository articleRepository;

  @Mock
     private  ArticleMapper articleMapper;
     private ArticleDTO articleDTO= new ArticleDTO();
      private Article article = new Article();


    @Before
    public void setUp() {
        when(articleMapper.toDto(article)).thenReturn(articleDTO);
        articleDTO.setId(2L);
        articleDTO.setHeadline("test_headline");
        articleDTO.setDescription("test_sample");
        articleDTO.setAuthor("test_author");

        when(articleMapper.toEntity(articleDTO)).thenReturn(article);
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
        Mockito.when(articleRepository.findAll()).thenReturn(Collections.singletonList(article));

        List<ArticleDTO> articleDTOList = articleService.findAll();

        assertNotNull(articleDTOList);
        Mockito.verify(articleRepository).findAll();
        Mockito.verifyNoMoreInteractions(articleRepository);


    }

    @Test
    public void findById() {
        when(articleRepository.findById(2l)).thenReturn(Optional.of(article));
        ArticleDTO articleDTO = articleService.findById(2l);
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
        ArticleDTO updatedArticleDto = articleService.updateById(2l,articleDTO);
        assertNotNull(updatedArticleDto);
        assertEquals(article.getId(), updatedArticleDto.getId());
        assertEquals(article.getHeadline(), updatedArticleDto.getHeadline());
        assertEquals(article.getDescription(), updatedArticleDto.getDescription());
        assertEquals(article.getAuthor(), updatedArticleDto.getAuthor());

    }

    @Test
    public void shouldThrowException_updateArticle() {
        String exceptionMessage = String.format("Article Not Found.", 2l);
        when(articleRepository.findById(2l)).thenThrow(new ArticleNotFoundException(exceptionMessage));

        try {
            assertThrows(ArticleNotFoundException.class, () -> articleService.findById(2l));
            articleService.findById(2l);
        } catch (ArticleNotFoundException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }
    @Test
    public void deteleArticle() {
        Article article = new Article();
        article.setId(2l);
        doNothing().when(articleRepository).deleteById(2l);
        articleRepository.deleteById(2l);
        verify(articleRepository, times(1)).deleteById(2l);

    }

}