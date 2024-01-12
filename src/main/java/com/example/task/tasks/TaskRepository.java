package com.example.task.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
//import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.categories.Category;
import com.example.task.states.State;

@Repository
@Component
//public interface TaskRepository extends JpaRepository<, > {
public class TaskRepository implements ITaskRepository{

    private static final List<Task> taskList = new ArrayList<>();

static {
    Category category1 = new Category("cat 1", "1234567");
    State status1 = new State("status 1", "9876543");

    taskList.add(new Task("task 1", "task 1 description", category1, status1, "559ffa0a-5bb7-4207-a14e-93090623dec8"));

    
    Category category2 = new Category("cat 1", "2345678");
    State status2 = new State("status 2", "8765432");

    taskList.add(new Task("task 2", "task 2 description", category2, status2, "559ffa0a-5bb7-4207-a14e-93090623dec7"));

    Category category3 = new Category("cat 1", "3456789");
    State status3 = new State("status 3", "7654321");

    taskList.add(new Task("task 3", "task 3 description", category3, status3, "559ffa0a-5bb7-4207-a14e-93090623dec9"));
}


    @Override
    public Collection<Task> findAll() {
        return taskList;
    }

    @Override
    public Task save(Task task) {
        return task;
    }
   /*
    @Override
    public Optional<Task> findById(String taskId) {
        Task task = taskList.get(taskId);
        return Optional.ofNullable(task);
    }

    */

    @Override
    public void delete(Task deletedTask) {
        taskList.remove(deletedTask);
    }

     @Override
    public Optional<Task> findOne(Example<Task> of) {
        return Optional.ofNullable(taskList.get(0));
    }
    @Override
    public Task findOneByUuid(String uuid) {
        Category category = new Category("cat 1", "1234567");
        State status = new State("status 1", "9876543");
        return new Task("Task 1", "description", category, status, uuid);
    }
}

