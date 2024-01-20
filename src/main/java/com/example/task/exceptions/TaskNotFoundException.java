package com.example.task.exceptions;

public class TaskNotFoundException  extends TaskManagerEntityNotFoundException {
    public TaskNotFoundException(String uuid) {
        super("Task", uuid);
    }
}
