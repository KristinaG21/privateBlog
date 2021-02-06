package com.example.privateblog.service;

import com.example.privateblog.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> findAll();

    ArticleDTO save(ArticleDTO articleDTO);

    ArticleDTO findById(Long id);

    ArticleDTO updateById(Long id, ArticleDTO articleDTO);

    void deleteById(Long id);

}
