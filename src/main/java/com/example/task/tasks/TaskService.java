package com.example.task.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;


import com.example.task.categories.Category;
import com.example.task.categories.CategoryDTO;
import com.example.task.categories.CategoryRepository;
import com.example.task.states.State;
import com.example.task.states.StateRepository;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Collections;


@Component
public class TaskService implements ITaskService{
    @Autowired
    private TaskMapper mapper;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StateRepository statusRepository;

    public List<TaskDTO> getAll() {
        return taskRepository
               .findAll()
               .stream()
               .map(task -> mapper.toDTO(task))
               .collect(Collectors.toList());
    }

   @Override
    public TaskDTO create(TaskDTO dto) {
        List<Category> categories = Collections.emptyList();
        State status = null;
        if (!CollectionUtils.isEmpty(dto.getCategories())) {
            categories = categoryRepository.findAllByUuidIn(dto.getCategories().stream().map(CategoryDTO::getUuid).toList());
        }

        if (dto.getStatus() != null && dto.getStatus().getUuid() != null) {

            Optional<State> statusByUuid = statusRepository.getStatusByUuid(dto.getStatus().getUuid());
            if (statusByUuid.isPresent()) {
                status = statusByUuid.get();
            }
        }

        Task task = mapper.toModel(dto);
        task.setCategories(categories);
        task.setStatus(status);
        Task savedTask = taskRepository.save(task);
        return mapper.toDTO(savedTask);
    }

    @Override
    public TaskDTO edit(TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(taskDTO.getUuid());
        List<Category> categories = Collections.emptyList();
        State status = null;
        if (!CollectionUtils.isEmpty(taskDTO.getCategories())) {
            categories = categoryRepository.findAllByUuidIn(taskDTO.getCategories().stream().map(CategoryDTO::getUuid).toList());
        }

        if (taskDTO.getStatus() != null && taskDTO.getStatus().getUuid() != null) {

            Optional<State> statusByUuid = statusRepository.getStatusByUuid(taskDTO.getStatus().getUuid());
            if (statusByUuid.isPresent()) {
                status = statusByUuid.get();
            }
        }

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setStatus(status);
        task.setCategories(categories);

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(UUID uuid) {
        Task task = new Task(uuid);
        Optional<Task> task1 = taskRepository.findOne(Example.of(task));

        return mapper.toDTO(task1.get());
    }

    @Override
    public TaskDTO delete(UUID uuid) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(uuid);

        Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }

    
}
