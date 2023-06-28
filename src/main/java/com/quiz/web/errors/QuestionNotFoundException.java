package com.quiz.web.errors;

public class QuestionNotFoundException extends RuntimeException{
    private static final long serialVersionId = 2;

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
