package com.example.privateblog.controller;


import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {

        @Autowired
        private ArticleService articleService;

        @GetMapping
        public List<ArticleDTO> findAll() {
            return articleService.findAll();
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
