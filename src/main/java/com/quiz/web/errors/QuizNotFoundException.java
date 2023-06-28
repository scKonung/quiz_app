package com.quiz.web.errors;

public class QuizNotFoundException extends RuntimeException{
    private static final long serialVersionId = 1;

    public QuizNotFoundException(long id) {
        super("Quiz with id:" +id+" not found in database");
    }
}
