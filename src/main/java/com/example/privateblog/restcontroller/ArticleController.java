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
        model.addAttribute("articles",articleService.findAll());
        return "articles";
    }


    @GetMapping("/{id}")
    public ArticleDTO findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping
    public ArticleDTO save(@RequestBody ArticleDTO articleDTO) {
        return articleService.save(articleDTO);
    }

    @PutMapping("/{id}")
    public ArticleDTO updateById(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        return articleService.updateById(id, articleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        articleService.deleteById(id);
    }
}
