package com.aviral.quizzy.controllers;

import com.aviral.quizzy.entities.Quiz;
import com.aviral.quizzy.sevices.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create
    @PostMapping
    private Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    // Get All
    @GetMapping
    private List<Quiz> getAllQuiz() {
        return quizService.get();
    }

    // Get Quiz by ID
    @GetMapping("/{id}")
    private Quiz getQuizById(@PathVariable Long id) {
        return quizService.get(id);
    }
}
