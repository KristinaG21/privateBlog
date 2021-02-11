package com.example.privateblog.exception;

public class ArticleNotFoundException extends Exception{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
