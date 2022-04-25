package com.example.libraryapplication.model.exceptions;

public class AuthorDoesNotExistException extends RuntimeException{
    public AuthorDoesNotExistException() {
        super("Author does not exist!");
    }
}
