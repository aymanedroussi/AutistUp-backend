package com.autistup.app.services;

import com.autistup.app.entities.Article;
import com.autistup.app.entities.Forum;
import com.autistup.app.entities.Question;
import com.autistup.app.repositories.ForumRepository;
import com.autistup.app.repositories.QuestionRepository;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.QuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ForumRepository forumRepository;


    @Override
    public List<QuestionDto> getAllQuestions(Long id) {
        List<Question> questions = questionRepository.findAllByForumId(id);
        List<QuestionDto> questionsDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Question question : questions ){
            QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);

            questionsDtos.add(questionDto);
        }
        return questionsDtos;
    }

    @Override
    public void addQuestion(QuestionDto questionDto) {
        ModelMapper modelMapper=new ModelMapper();
        Question question = modelMapper.map(questionDto, Question.class);
        Forum forum = forumRepository.findById(questionDto.getForumId()).get();
        question.setId(null);
        question.setForum(forum);
        question.setAuteur(questionDto.getAuteur());
        questionRepository.save(question);

    }
}
