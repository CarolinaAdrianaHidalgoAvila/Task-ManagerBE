package com.example.task.tasks;
import java.sql.Timestamp;

import com.example.task.categories.Category;
import com.example.task.states.State;

public class Task {
    private String taskId;
    private String  name;
    private String description;
    private Category category;
    private Timestamp endedDate;
    private State state;

    private String uuid;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;
    
    public Task(String name, String description, Category category, State status, String uuid) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.state = status;
        this.uuid = uuid;
    }

    public Task(String uuid) {
        this.uuid = uuid;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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
        return state;
    }

    public void setStatus(State status) {
        this.state = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    

    
}
