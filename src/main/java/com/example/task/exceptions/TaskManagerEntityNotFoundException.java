package com.example.task.exceptions;

public class TaskManagerEntityNotFoundException extends RuntimeException {
    public TaskManagerEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}
