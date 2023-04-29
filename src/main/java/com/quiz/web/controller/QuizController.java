package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
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
        //dowload to a list all quzzes from a repository
        List<QuizDto> quizDtoList = quizService.findAllQuizzes();
        //add to the model atribute a quizzes
        model.addAttribute("quizzes",quizDtoList);
        //return name of a html file with page for quizzes list
        return "quiz-list";
    }
}
