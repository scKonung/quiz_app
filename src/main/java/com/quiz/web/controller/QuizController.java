package com.quiz.web.controller;

import com.quiz.web.dto.QuizDto;
import com.quiz.web.models.Quiz;
import com.quiz.web.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public String create(@Valid @ModelAttribute("quiz")QuizDto quizDto,
                         BindingResult result, Model model){
        if (result.hasErrors()){
            addQuizAndTypes(model, quizDto);
            return "quiz_create";
        }
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
        //add types to the model attribute
        addQuizAndTypes(model,quizService.findById(quizId));
        //direct to edit form
        return "quiz_edit";
    }
    //post request for updating a data
    @PostMapping("/quizzes/{id}/edit")
    public String update(@PathVariable("id") long quizId, @Valid @ModelAttribute("quiz") QuizDto quizDto,
                         BindingResult result, Model model){
        if(result.hasErrors()) {
            addQuizAndTypes(model,quizDto);
            return "quiz_edit";
        }
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

    //get a list of quizzes by name
    @GetMapping("/quizzes/search")
    public String searchByName(@RequestParam(value = "query") String query,
                               Model model) {
        model.addAttribute("quizzes", quizService.searchByName(query));
        return "quiz_list";
    }

    @GetMapping("/quiz{quizId}/game")
    public String start(@PathVariable("quizId") long quizId, Model model){
        model.addAttribute("quiz",quizService.findById(quizId));
        return "quiz_game";
    }

    //method for add attributes
    private void addQuizAndTypes(Model model, QuizDto quizDto){
        model.addAttribute("quiz",quizDto);
        model.addAttribute("types",quizService.findAllTypes());
    }

}
