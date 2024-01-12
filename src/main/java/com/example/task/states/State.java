package com.example.task.states;

import java.sql.Timestamp;

public class State {
    private String stateId;
    private String  name;

    private String uuid;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;
   
    public State(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }
    public State(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getStateId() {
        return stateId;
    }
    public void setStateId(String stateId) {
        this.stateId = stateId;
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