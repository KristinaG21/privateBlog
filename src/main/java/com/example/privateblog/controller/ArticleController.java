package com.example.privateblog.controller;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private static final String ARTICLES = "articles";
    private static final String REDIRECT_ARTICLE_ID = "redirect:/articles";

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("newArticle",new ArticleDTO());
        model.addAttribute(ARTICLES,articleService.findAll());
        return ARTICLES;
    }



    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) throws Exception {
        ArticleDTO articleDTO = articleService.findById(id);
        model.addAttribute("post",articleDTO);
        return "post" ;
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute ArticleDTO articleDTO,Model model) {
        ArticleDTO newArticle = articleService.save(articleDTO);
        model.addAttribute("newArticle", newArticle);
        return REDIRECT_ARTICLE_ID;
    }


    @PostMapping("/{id}/update")
    public String updateById(@PathVariable Long id, @ModelAttribute ArticleDTO articleDTO, Model model) throws Exception {
        ArticleDTO updateArticle = articleService.updateById(id,articleDTO);
        model.addAttribute(ARTICLES, updateArticle);
        return REDIRECT_ARTICLE_ID;
    }


    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id) throws Exception {
        articleService.deleteById(id);
        return REDIRECT_ARTICLE_ID;
    }

}
