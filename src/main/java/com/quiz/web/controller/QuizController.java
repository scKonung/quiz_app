package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.models.Type;
import com.quiz.web.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
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
    public String getListOfQuizzes(Model model){
        //dowload to a list all quzzes from a repository
        List<QuizDto> quizDtoList = quizService.findAllQuizzes();
        //add to the model atribute a quizzes
        model.addAttribute("quizzes",quizDtoList);
        //return name of a html file with page for quizzes list
        return "quiz_list";
    }
    //get mapping for a get a page form for a creating a quiz
    @GetMapping("/quizzes/new")
    public String createQuizForm(Model model){
       //create a object quiz
        Quiz quiz = new Quiz();
        //create a list of types for choosing a type for quiz
        List<Type> types = quizService.findAllTypes();
        //add quiz to the model attribute
        model.addAttribute("quiz",quiz);
        //add types to the model attribute
        model.addAttribute("types",types);
        //return page for creating a quiz
        return "quiz_create";
    }
    //post mappping for a creating quiz
    @PostMapping("/quizzes/new")
    public String createQuiz(Model model,@ModelAttribute("quiz")QuizDto quizDto){
        quizService.saveQuiz(quizDto);
        return "redirect:/quizzes";
    }
}
