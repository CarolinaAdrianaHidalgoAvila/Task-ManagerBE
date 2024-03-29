package com.example.task.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public List<TaskDTO> getAll(@RequestParam(value = "categoryId", required = false) List<String> categoryIdList) {
        return taskService.getAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<TaskDTO> getOne(@PathVariable String uuid) {
        try {
            TaskDTO task = taskService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(task);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO dto) {
     
        return taskService.create(dto);
    }
    @PutMapping
    public TaskDTO edit(@RequestBody TaskDTO dto) {
        return taskService.edit(dto);
    }
    
    @DeleteMapping("/{uuid}")
    public TaskDTO delete(@PathVariable String uuid) {
        return taskService.delete(UUID.fromString(uuid));
    }
    
    
    
}
