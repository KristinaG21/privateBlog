package com.example.privateblog.service;

import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.exception.ArticleNotFoundException;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> findAll();

    ArticleDTO save(ArticleDTO articleDTO);

    ArticleDTO findById(Long id) throws ArticleNotFoundException;

    ArticleDTO updateById(Long id, ArticleDTO articleDTO) throws ArticleNotFoundException;

    void deleteById(Long id) throws ArticleNotFoundException;

}
