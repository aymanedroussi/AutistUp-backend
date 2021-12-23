package com.autistup.app.controllers;

import com.autistup.app.requests.ArticleRequest;
import com.autistup.app.requests.ForumRequest;
import com.autistup.app.requests.QuestionRequest;
import com.autistup.app.responses.ArticleResponse;
import com.autistup.app.responses.ForumResponse;
import com.autistup.app.responses.QuestionResponse;
import com.autistup.app.services.ForumService;
import com.autistup.app.services.QuestionService;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.ForumDto;
import com.autistup.app.sharedDto.QuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    QuestionService questionService;

    @Autowired
    ForumService forumService;

    @GetMapping(path="/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ForumResponse>> getAllForums() {

        List<ForumDto> forums = forumService.findAll();

        List<ForumDto> forumDtos = forumService.findAll();
        List<ForumResponse> forumResponses = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (ForumDto forum : forumDtos) {
            ForumResponse ForumResponse = modelMapper.map(forum, ForumResponse.class);
            forumResponses.add(ForumResponse);
        }
        return new ResponseEntity<List<ForumResponse>>(forumResponses, HttpStatus.OK);


    }

    @GetMapping(path="/getAllQuestions/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<QuestionResponse>> getAllQuestions(@PathVariable(name="id") String id) {

        List<QuestionDto> questionDtos = questionService.getAllQuestions(new Long(id));


        List<QuestionResponse> questionResponses = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (QuestionDto question : questionDtos) {
            QuestionResponse questionResponse= modelMapper.map(question, QuestionResponse.class);
            questionResponses.add(questionResponse);
        }
        return new ResponseEntity<List<QuestionResponse>>(questionResponses, HttpStatus.OK);


    }

    @PostMapping(path="/add",consumes ={MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleResponse> addQuestion(@RequestBody QuestionRequest questionRequest){
        ModelMapper modelMapper=new ModelMapper();
        QuestionDto questionDto = modelMapper.map(questionRequest, QuestionDto.class);
        questionService.addQuestion(questionDto);
        return new ResponseEntity(questionDto,HttpStatus.CREATED);
    }

    @PostMapping(path="/addForum",consumes ={MediaType.APPLICATION_JSON_VALUE})
    public void addForum(@RequestBody ForumRequest forumRequest){
        ModelMapper modelMapper=new ModelMapper();
        ForumDto forumDto = modelMapper.map(forumRequest, ForumDto.class);
        forumService.addForum(forumDto);

    }
    
}


