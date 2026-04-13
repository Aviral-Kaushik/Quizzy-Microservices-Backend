package com.aviral.question.services;


import com.aviral.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> getAll();

    Question getQuestionById(Long id);

    List<Question> getQuestionsByQuizId(Long quizId);
}
