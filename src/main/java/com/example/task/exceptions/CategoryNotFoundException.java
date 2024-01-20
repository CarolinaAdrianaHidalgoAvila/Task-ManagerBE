package com.example.task.exceptions;

public class CategoryNotFoundException extends TaskManagerEntityNotFoundException {
    public CategoryNotFoundException(String uuids) {
        super("Category", uuids);
    }
}
