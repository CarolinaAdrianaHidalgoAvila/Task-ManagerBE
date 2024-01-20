package com.example.task.exceptions;


public class StatusNotFound extends TaskManagerEntityNotFoundException {
    public StatusNotFound(String uuid) {
        super("Status", uuid);
    }
}