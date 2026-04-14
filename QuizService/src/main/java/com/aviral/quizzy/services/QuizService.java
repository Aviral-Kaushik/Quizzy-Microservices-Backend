package com.aviral.quizzy.services;

import com.aviral.quizzy.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
