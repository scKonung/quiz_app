package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
       /* //create a object quiz
        Quiz quiz = new Quiz();
        //add quiz to the model attribute
        model.addAttribute("quiz",quiz);
        //return page for creating a quiz*/
        return "quiz_create";
    }
    //post mappping for a creating quiz
    /*@PostMapping("/quizzes/create")
    public String createQuiz(Model model,@Valid @ModelAttribute("quiz")QuizDto quizDto,
                             BindingResult result ){
        if(result.hasErrors()){
            return "quiz-create";
        }
        quizService.saveQuiz(quizDto);
        return "redirect:/quizzes";
    }*/
}
