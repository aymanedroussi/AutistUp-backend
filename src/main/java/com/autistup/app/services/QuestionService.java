package com.autistup.app.services;

import com.autistup.app.entities.Question;
import com.autistup.app.sharedDto.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions(Long id);

    void addQuestion(QuestionDto questionDto);
}
