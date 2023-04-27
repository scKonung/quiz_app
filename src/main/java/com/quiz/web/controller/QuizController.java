package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuizController {
    private QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //get mapping for return all quizzes from repository
    @GetMapping("/quizzes")
    public String getListOfQuizzes(Model model) {
        List<QuizDto> quizDtoList = quizService.findAllQuizzes();
        model.addAttribute("quizzes",quizDtoList);
        return "quiz-list";
    }
}
