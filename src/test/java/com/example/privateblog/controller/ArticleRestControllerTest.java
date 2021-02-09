package com.example.privateblog.controller;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ArticleRestControllerTest {
    @InjectMocks
    private ArticleRestController articleRestController = new ArticleRestController();

    @Mock
    private ArticleService articleService;

    private ArticleDTO articleDTO;

    @Before
    public void setUp() {
        articleDTO = new ArticleDTO();
        articleDTO.setId(2l);
        articleDTO.setHeadline("test_headline");
        articleDTO.setDescription("test");
        articleDTO.setAuthor("test_name");
    }

    @Test
    public void findAll() {

        Mockito.when(articleService.findAll()).thenReturn(Collections.singletonList(articleDTO));

        List<ArticleDTO> articleDTOList = articleRestController.findAll();

        assertNotNull(articleDTOList);
        Mockito.verify(articleService).findAll();
        Mockito.verifyNoMoreInteractions(articleService);

    }

    @Test
    public void findById() {
        when(articleService.findById(2l)).thenReturn(articleDTO);
        ArticleDTO articleDTO = articleRestController.findById(2l);
        assertNotNull(articleDTO);
        Mockito.verify(articleService).findById(2l);
        Mockito.verifyNoMoreInteractions(articleService);

    }

    @Test
    public void saveArticle() {
        when(articleService.save(Mockito.any(ArticleDTO.class))).thenReturn(articleDTO);
        ArticleDTO save = articleRestController.save(articleDTO);
        verify(articleService, times(1)).save(Mockito.any(ArticleDTO.class));
        Mockito.verifyNoMoreInteractions(articleService);
    }

    @Test
    public void updateById() {
        articleDTO.setId(2l);
        articleDTO.setHeadline("test_headline");
        articleDTO.setDescription("test");
        articleDTO.setAuthor("test_name");
        when(articleService.updateById(2l, articleDTO)).thenReturn(articleDTO);
        ArticleDTO updatedArticleDto = articleRestController.updateById(2l, articleDTO);
        assertNotNull(updatedArticleDto);
        Mockito.verify(articleService).updateById(2l, articleDTO);
    }


    @Test
    public void deleteById() {
        doNothing().when(articleService).deleteById(2l);
        articleRestController.deleteById(2l);
        verify(articleService, times(1)).deleteById(2l);
    }

}