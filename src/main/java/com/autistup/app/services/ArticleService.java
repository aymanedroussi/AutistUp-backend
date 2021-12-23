package com.autistup.app.services;

import com.autistup.app.sharedDto.ArticleDto;

import java.util.List;

public interface ArticleService {
    public List<ArticleDto> getAllArticles();
    public void deleteArticle(Long id);
    public void addArticle(ArticleDto articleDto);
    public void updateArticle(ArticleDto articleDto,Long id);
    public ArticleDto getArticleById(Long id);
}
