package com.aviral.quizzy.services.impl;

import com.aviral.quizzy.entities.Quiz;
import com.aviral.quizzy.repositories.QuizRepository;
import com.aviral.quizzy.services.QuestionClient;
import com.aviral.quizzy.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes =  quizRepository.findAll();

        return quizzes.stream().peek(quiz ->
                quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()))).toList();
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found!"));

        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;

//        Optional<Quiz> quizData = quizRepository.findById(id);
//
//        if (quizData.isPresent())
//            return quizData.get();
//
//        return null;
    }
}
