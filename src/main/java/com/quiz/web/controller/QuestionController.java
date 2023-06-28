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
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    private final QuestionService questionService;


    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //crud read
    @GetMapping("/quiz{quizId}/questions")
    public String getAll(@PathVariable("quizId") long quizId, Model model) {
        //get all questions by id in service
        List<QuestionDto> questionDtos = questionService.getAllByQuizId(quizId);
        String quizName = questionDtos.get(0).getQuiz().getName();
        //add list to the model
        model.addAttribute("questions",questionDtos);
        model.addAttribute("quizName",quizName);
        return "question_list";
    }

    //crud create
    @GetMapping("/questions/{clubId}/new")
    public String create(@PathVariable("clubId") long quizId, Model model){
        Question question = new Question();
        //make the empty array to add answers in form
        List<String> answers = new ArrayList<>();
        for (int j=0;j<=3;j++)
            answers.add("");
        question.setAnswers(answers);

        //add to the model object and id
        model.addAttribute("question",question);
        model.addAttribute("quizId",quizId);
        return "question_create";
    }

    @PostMapping("/questions/{quizId}/new")
    public String create(@PathVariable("quizId")long quizId, @ModelAttribute("question")QuestionDto questionDto) {
        questionService.create(quizId,questionDto);
        return "redirect:/quizzes/" + quizId;
    }
}
