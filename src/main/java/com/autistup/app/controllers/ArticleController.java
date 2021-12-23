package com.autistup.app.controllers;

import com.autistup.app.requests.ArticleRequest;
import com.autistup.app.requests.VideoRequest;
import com.autistup.app.responses.ArticleResponse;
import com.autistup.app.responses.VideoResponse;
import com.autistup.app.services.ArticleService;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/formation/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping(path="/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ArticleResponse>> getArticles(){
        List<ArticleDto> articleDtos = articleService.getAllArticles();
        List<ArticleResponse> articleResponses=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(ArticleDto articleDto : articleDtos ){
            ArticleResponse articleResponse = modelMapper.map(articleDto, ArticleResponse.class);
            articleResponses.add(articleResponse);
        }
        return new ResponseEntity<List<ArticleResponse>>(articleResponses, HttpStatus.OK);
    }

    @PostMapping(path="/add",consumes ={MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleResponse> addArticles(@RequestBody ArticleRequest articleRequest){
        ModelMapper modelMapper=new ModelMapper();
        ArticleDto articleDto = modelMapper.map(articleRequest, ArticleDto.class);
        articleService.addArticle(articleDto);
        return new ResponseEntity(articleDto,HttpStatus.CREATED);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<ArticleResponse> deleteArticles(@PathVariable(name="id") String id){
        Long idLong=new Long(id);
        articleService.deleteArticle(idLong);
        return new ResponseEntity(new ArticleResponse(),HttpStatus.NO_CONTENT);
    }

    @PutMapping(path="/update/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleResponse> updateMapping(@PathVariable(name="id") String id,@RequestBody ArticleRequest articleRequest){
        ModelMapper modelMapper=new ModelMapper();
        ArticleDto articleDto = modelMapper.map(articleRequest, ArticleDto.class);
        articleService.updateArticle(articleDto,new Long(id));
        return new ResponseEntity(articleDto,HttpStatus.CREATED);

    }


    @GetMapping(path="/get/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleResponse> getArticles(@PathVariable(name="id") String id){
        ArticleDto article = articleService.getArticleById(new Long(id));
        ModelMapper modelMapper=new ModelMapper();
        ArticleResponse articleResponse = modelMapper.map(article, ArticleResponse.class);
        return new ResponseEntity<ArticleResponse>(articleResponse, HttpStatus.OK);
    }

}
