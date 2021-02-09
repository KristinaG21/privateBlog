package com.example.privateblog.restcontroller;

import com.example.privateblog.controller.ArticleRestController;
import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import com.example.privateblog.mapper.ArticleMapper;
import com.example.privateblog.repository.ArticleRepository;
import com.example.privateblog.service.ArticleService;
import com.example.privateblog.service.serviceimpl.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {
   @InjectMocks
   private ArticleController articleController = new ArticleController();

   @Mock
   private ArticleService articleService;

   @Mock
   private Model model;

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
      when(model.addAttribute("articles", articleService.findAll())).thenReturn(model);
      String view = articleController.findAll(model);
      assertEquals("articles", view);

   }

   @Test
   public void findById() {
      when(articleService.findById(2l)).thenReturn(articleDTO);
      when(model.addAttribute("post", articleService.findById(2l))).thenReturn(model);
      String view = articleController.findById(2l, model);
      assertEquals("post", view);
   }


   @Test
   public void saveArticle() {
      ArticleDTO newArticle = new ArticleDTO();
      when(articleService.save(articleDTO)).thenReturn(newArticle);
      String view = articleController.saveArticle(articleDTO, model);
      assertEquals("redirect:/articles", view);
   }

   @Test
  public void updateById() {
      articleDTO.setId(2l);
      articleDTO.setHeadline("test_headline");
      articleDTO.setDescription("test");
      articleDTO.setAuthor("test_name");
      when(articleService.updateById(2l, articleDTO)).thenReturn(articleDTO);
      String s = articleController.updateById(2l, articleDTO, model);
      assertEquals("redirect:/articles", s);
   }

   @Test
   public void deleteById() {
      doNothing().when(articleService).deleteById(2l);
      String view = articleController.deleteById(2l);
      assertEquals("redirect:/articles", view);
      verify(articleService, times(1)).deleteById(2l);
   }
}