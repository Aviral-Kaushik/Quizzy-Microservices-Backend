package com.aviral.question.controllers;

import com.aviral.question.entities.Question;
import com.aviral.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    private Question createQuestion(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    private List<Question> getAllQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    private Question getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/quiz/{quizId}")
    private List<Question> getQuestionByQuestionId(@PathVariable Long quizId) {
        return questionService.getQuestionsByQuizId(quizId);
    }
}
