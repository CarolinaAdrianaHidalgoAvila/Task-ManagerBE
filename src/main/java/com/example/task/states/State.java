package com.example.task.states;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.task.tasks.Task;

import java.sql.Timestamp;

import java.util.UUID;

@Entity
@SQLDelete(sql = "UPDATE Status SET deleted = true WHERE status_id=?")

public class State {
    @Id
    @GeneratedValue
    private Long statusId;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = true, length = 2000)
    private String description;
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private UUID uuid;
    @Column(updatable = false, columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @CreatedDate
    private Timestamp createdDate;
    @Column(columnDefinition = "timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @LastModifiedDate
    private Timestamp modifiedDate;
    @CreatedBy
    private Integer createdBy;
    @LastModifiedBy
    private Integer modifiedBy;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")
    private boolean deleted;

    
    @OneToOne(mappedBy = "status")
    private Task task;

   
    public State() {
    }

    public State(UUID uuid) {
        this.uuid = uuid;
    }

    public State(UUID uuid, String name, String description) {
        this.name = name;
        this.description = description;
        this.uuid = uuid;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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