package com.example.privateblog.restcontroller;

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


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("newArticle",new ArticleDTO());
        model.addAttribute("articles",articleService.findAll());
        return "articles";
    }



    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        ArticleDTO articleDTO = articleService.findById(id);
        model.addAttribute("post",articleDTO);
        return "post" ;
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute ArticleDTO articleDTO,Model model) {
        ArticleDTO newArticle = articleService.save(articleDTO);
        model.addAttribute("newArticle", newArticle);
        return "redirect:/articles";
    }


    @PostMapping("/{id}/update")
    public String updateById(@PathVariable Long id, @ModelAttribute ArticleDTO articleDTO, Model model) {
        ArticleDTO updateArticle = articleService.updateById(id,articleDTO);
        model.addAttribute("articles", updateArticle);
        return "redirect:/articles";
    }


    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        articleService.deleteById(id);
        return "redirect:/articles";
    }

}
