package com.example.task.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.task.categories.Category;
import com.example.task.categories.CategoryDTO;
import com.example.task.categories.CategoryMapper;
import com.example.task.states.StateMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TaskMapper {

       @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StateMapper statusMapper;

    public TaskDTO toDTO(Task task) {
        List<CategoryDTO> categories = Optional.ofNullable(task.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> categoryMapper.toDTO(c))
                .toList();

        return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), categories, statusMapper.toDTO(task.getStatus()));
    }
      public Task toModel(TaskDTO dto) {
        List<Category> categories = Optional.ofNullable(dto.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> categoryMapper.toModel(c))
                .toList();
        return new Task(dto.getName(), dto.getDescription(), categories, statusMapper.toModel(dto.getStatus()), dto.getUuid());
    }
    
}
