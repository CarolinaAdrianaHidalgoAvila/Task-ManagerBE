package com.example.task.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            TaskDTO task = taskService.getOne(uuid);
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
        return taskService.delete(uuid);
    }
    
    
    
}
