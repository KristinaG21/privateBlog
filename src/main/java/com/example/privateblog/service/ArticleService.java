package com.example.privateblog.service;

import com.example.privateblog.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> findAll();

    ArticleDTO save(ArticleDTO articleDTO);

    ArticleDTO findById(Long id) throws Exception;

    ArticleDTO updateById(Long id, ArticleDTO articleDTO) throws Exception;

    void deleteById(Long id) throws Exception;

}
