package com.example.libraryapplication.model.exceptions;

public class BookDoesNotExistException extends RuntimeException{
    public BookDoesNotExistException() {
        super("Book does not exist!");
    }
}
