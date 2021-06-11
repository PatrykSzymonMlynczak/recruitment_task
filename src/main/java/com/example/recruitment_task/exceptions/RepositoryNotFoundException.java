package com.example.recruitment_task.exceptions;

public class RepositoryNotFoundException extends RuntimeException {

    public RepositoryNotFoundException() {
        super("Repository not found");
    }
}
