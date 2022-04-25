package com.example.libraryapplication.model.exceptions;

public class NoMoreCopiesException extends RuntimeException{
    public NoMoreCopiesException() {
        super("Book has no more copies!");
    }
}
