package com.quiz.web.controller;

import com.quiz.web.dto.QuestionDto;
import com.quiz.web.models.Question;
import com.quiz.web.service.QuestionService;
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
    @GetMapping("/quiz{quizId}/questions/new")
    public String create(@PathVariable("quizId") long quizId, Model model){
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
    @PostMapping("/quiz{quizId}/questions/new")
    public String create(@PathVariable("quizId")long quizId,
                         @ModelAttribute("question")QuestionDto questionDto) {
        questionService.create(quizId,questionDto);
        return "redirect:/quiz"+quizId+"/questions";
    }

    //crud update
    @GetMapping("/quiz{quizId}/questions/{questionId}/edit")
    public String update(@PathVariable("quizId") long quizId,
                         @PathVariable("questionId") long questionId,
                         Model model){
        //add to model id of quiz and questions and question by id
        model.addAttribute("quizId",quizId);
        model.addAttribute("questionId",questionId);
        model.addAttribute("question",questionService.findById(questionId));
        return "question_edit";
    }
    @PostMapping("/quiz{quizId}/questions/{questionId}/edit")
    public String update(@PathVariable("quizId") long quizId,
                         @PathVariable("questionId") long questionId,
                         @ModelAttribute("question") QuestionDto questionDto,
                         BindingResult result, Model model) {
        questionDto.setId(questionId);
        questionService.update(questionDto, quizId);
        return "redirect:/quiz"+quizId+"/questions";
    }

    //crud delete
    @GetMapping("/quiz{quizId}/questions/{questionId}/delete")
    public String delete(@PathVariable("quizId") long quizId,
                         @PathVariable("questionId") long questionId) {
        questionService.delete(questionId);
        return "redirect:/quiz"+quizId+"/questions";
    }
}
