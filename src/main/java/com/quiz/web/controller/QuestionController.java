package com.quiz.web.controller;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.models.Question;
import com.quiz.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {
    private final QuestionService questionService;
    @Autowired
    public QuestionController( QuestionService questionService) {
        this.questionService = questionService;}

    @GetMapping("/questions/{clubId}/new")
    public String create(@PathVariable("clubId") long quizId, Model model){
        Question question = new Question();
        model.addAttribute("question",question);
        model.addAttribute("quizId",quizId);
        return "question_create";
    }

    @PostMapping("/questions/{quizId}")
    public String create(@PathVariable("quizId")long quizId, @ModelAttribute("question")QuestionDto questionDto) {
        questionService.create(quizId,questionDto);
        return "redirect:/quizzes/" + quizId;
    }
}
