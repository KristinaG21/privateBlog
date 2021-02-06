package com.example.privateblog.service.serviceimpl;


import com.example.privateblog.dto.ArticleDTO;
import com.example.privateblog.entity.Article;
import com.example.privateblog.exception.ArticleNotFoundException;
import com.example.privateblog.mapper.ArticleMapper;
import com.example.privateblog.repository.ArticleRepository;
import com.example.privateblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<ArticleDTO> findAll() {
     return articleRepository.findAll().stream()
                .map(article -> articleMapper.toDto(article))
                .collect(Collectors.toList());

    }
    @Override
    public ArticleDTO findById(Long id) {
       Article byId = articleRepository.findById(id).orElseThrow(()-> new ArticleNotFoundException("Article Not Found"));
       return articleMapper.toDto(byId);
    }

    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
     Article article = articleMapper.toEntity(articleDTO);
     Article saveArticle = articleRepository.save(article);
     return articleMapper.toDto(saveArticle);

    }
    
    @Override
    public ArticleDTO updateById(Long id, ArticleDTO articleDTO) {
        Article foundById = articleRepository.findById(id).orElseThrow(()-> new ArticleNotFoundException("Article Not Found"));
        foundById.setHeadline(articleDTO.getHeadline());
        foundById.setAuthor(articleDTO.getAuthor());
        foundById.setBody(articleDTO.getBody());
        Article updatedArticle = articleRepository.save(foundById);
        return articleMapper.toDto(updatedArticle);
    }

    @Override
    public void deleteById(Long id)throws ArticleNotFoundException{
        Optional<Article> articleById = articleRepository.findById(id);
        if(articleById.isPresent()){
            articleRepository.deleteById(id);
        }else {
            throw new ArticleNotFoundException("Article not Found");
        }


    }
}
