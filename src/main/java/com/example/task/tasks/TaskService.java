package com.example.task.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

import java.util.Optional;

@Service
@Component
public class TaskService implements ITaskService{
    @Autowired
    private TaskMapper mapper;

    @Autowired
    private ITaskRepository taskRepository;

    public List<TaskDTO> getAll() {
        return taskRepository
               .findAll()
               .stream()
               .map(task -> mapper.toDTO(task))
               .collect(Collectors.toList());
    }

    @Override
    public TaskDTO create(TaskDTO dto) {
       Task task = mapper.toModel(dto);
       Task savedTask = taskRepository.save(task);
       return mapper.toDTO(savedTask);
    }

    @Override
    public TaskDTO getOne(String uuid) {
        Task task = getTask(uuid);
        return mapper.toDTO(task);
    }

    public TaskDTO edit(TaskDTO taskDTO) {
        Task example1 = new Task(taskDTO.getUuid());
        Optional<Task> optionalTask = taskRepository.findOne(Example.of(example1));

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setStatus(taskDTO.getStatus());
        task.setCategory(taskDTO.getCategory());

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO delete(String uuid) {
        Task example1 = new Task(uuid);
        Optional<Task> optionalTask = taskRepository.findOne(Example.of(example1));

        Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }


    private Task getTask(String uuid) {
        Task task = taskRepository.findOneByUuid(uuid);
        return task;
    }

    
}
