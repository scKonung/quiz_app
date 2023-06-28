package com.quiz.web.errors;

public class QuestionNotFoundException extends RuntimeException{
    private static final long serialVersionId = 2;

    public QuestionNotFoundException(long questionId) {
        super("Can't find a question with id: " + questionId );
    }
}
