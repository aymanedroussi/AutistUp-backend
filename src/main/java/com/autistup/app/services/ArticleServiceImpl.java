package com.autistup.app.services;

import com.autistup.app.entities.Article;
import com.autistup.app.entities.VideoFormation;
import com.autistup.app.repositories.ArticleRepository;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;


    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> articleDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Article article : articles ){
            ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);

            articleDtos.add(articleDto);
        }
        return articleDtos;
    }

    @Override
    public void addArticle(ArticleDto articleDto) {
        ModelMapper modelMapper=new ModelMapper();
        Article article = modelMapper.map(articleDto, Article.class);
        articleRepository.save(article);

    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleDto articleDto,Long id) {
        ModelMapper modelMapper=new ModelMapper();
        Article article = modelMapper.map(articleDto, Article.class);
        article.setId(id);
        articleRepository.save(article);
    }

    @Override
    public ArticleDto getArticleById(Long id) {
        Article article = articleRepository.findById(id).get();
        ModelMapper modelMapper=new ModelMapper();
        ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
        return articleDto;
    }
}
