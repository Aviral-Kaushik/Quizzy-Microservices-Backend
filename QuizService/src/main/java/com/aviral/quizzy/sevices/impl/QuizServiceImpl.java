package com.aviral.quizzy.sevices.impl;

import com.aviral.quizzy.entities.Quiz;
import com.aviral.quizzy.rpositories.QuizRepository;
import com.aviral.quizzy.sevices.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found!"));
//        Optional<Quiz> quizData = quizRepository.findById(id);
//
//        if (quizData.isPresent())
//            return quizData.get();
//
//        return null;
    }
}
