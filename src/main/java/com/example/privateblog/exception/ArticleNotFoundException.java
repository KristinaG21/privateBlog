package com.example.privateblog.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
