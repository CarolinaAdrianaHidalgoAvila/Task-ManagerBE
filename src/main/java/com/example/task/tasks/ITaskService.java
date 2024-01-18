package com.example.task.tasks;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;


@Component
public interface ITaskService {

    public List<TaskDTO> getAll();

    TaskDTO create(TaskDTO dto);

    TaskDTO edit(TaskDTO dto);

    TaskDTO getOne(UUID uuid);

    TaskDTO delete(UUID uuid);
    
}
