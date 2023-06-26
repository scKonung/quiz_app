package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class QuizController {
    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //get request for return all quizzes from repository
    @GetMapping("/quizzes")
    public String getAll(Model model){
        //add to the model all quizzes
        model.addAttribute("quizzes",quizService.findAll());
        //return name of a html file with page for quizzes list
        return "quiz_list";
    }

    //crud read
    //get request for getting a quiz by id
    @GetMapping("/quizzes/{id}")
    public String read(Model model, @PathVariable("id")long id)  {
        //add to the model an object from db by using a service
        model.addAttribute("quiz",quizService.findById(id));
        //return a page of quiz
        return "quiz_page";
    }

    //crud create
    //get request for a empty quiz object
    @GetMapping("/quizzes/new")
    public String create(Model model){
       //create a object quiz
        Quiz quiz = new Quiz();
        //add quiz to the model attribute
        model.addAttribute("quiz",quiz);
        //add types to the model attribute
        model.addAttribute("types",quizService.findAllTypes());
        //return page for creating a quiz
        return "quiz_create";
    }
   //post request with created quiz in form
    @PostMapping("/quizzes/new")
    public String create(@ModelAttribute("quiz")QuizDto quizDto){
        //save object in db
        quizService.save(quizDto);
        //redirect to all quizzes page
        return "redirect:/quizzes";
    }

    //crud update

    //get request to get data from db in form
    @GetMapping("/quizzes/{id}/edit")
    public String update(@PathVariable("id")long quizId, Model model) {
        //add to the model an object from db using id
        model.addAttribute("quiz", quizService.findById(quizId));
        //add types to the model attribute
        model.addAttribute("types",quizService.findAllTypes());
        //direct to edit form
        return "quiz_edit";
    }
    //post request for updating a data
    @PostMapping("/quizzes/{id}/edit")
    public String update(@PathVariable("id") long quizId, @ModelAttribute("quiz") QuizDto quizDto){
        quizDto.setId(quizId);
        quizService.update(quizDto);
        return "redirect:/quizzes/" + quizId;
    }

    //crud delete
    @GetMapping("/quizzes/{id}/delete")
    public String delete(@PathVariable("id") long quizId){
        quizService.delete(quizId);
        return "redirect:/quizzes";
    }

}
