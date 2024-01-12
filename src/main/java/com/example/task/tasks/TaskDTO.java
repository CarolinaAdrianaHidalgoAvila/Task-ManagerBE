package com.example.task.tasks;
import java.sql.Timestamp;

import com.example.task.categories.Category;
import com.example.task.states.State;

public class TaskDTO {
    private String uuid;
    private String  name;
    private String description;
    private Category category;
    private Timestamp endedDate;
    private State status;

    public TaskDTO(){}
    
    public TaskDTO(String uuid, String name, String description, Category category, Timestamp endedDate, State status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.endedDate = endedDate;
        this.status = status;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Timestamp getEndedDate() {
        return endedDate;
    }
    public void setEndedDate(Timestamp endedDate) {
        this.endedDate = endedDate;
    }
    public State getStatus() {
        return status;
    }
    public void setStatus(State status) {
        this.status = status;
    }
    
}
