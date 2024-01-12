package com.example.task.tasks;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ITaskService {

    public List<TaskDTO> getAll();

    public TaskDTO create(TaskDTO dto);

    TaskDTO getOne(String uuid);

    public TaskDTO delete(String uuid);

    public TaskDTO edit(TaskDTO dto);
    
}
