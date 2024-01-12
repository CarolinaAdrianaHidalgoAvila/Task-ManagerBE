package com.example.task.tasks;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;

public interface ITaskRepository {
    Collection<Task> findAll();

    Task save(Task task);

    //Optional<Task> findById(String taskId);

    void delete(Task deletedTask);

    Optional<Task> findOne(Example<Task> of);

     Task findOneByUuid(String uuid);
}
