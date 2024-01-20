package com.example.task.exceptions;
import java.util.Date;
import java.util.Map;

public class StatusManagerFieldValidationException extends TaskManagerException {

    private Map<String, String> fieldErrors;


    public StatusManagerFieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}