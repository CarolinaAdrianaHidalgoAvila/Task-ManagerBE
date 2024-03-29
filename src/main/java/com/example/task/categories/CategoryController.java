package com.example.task.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/categories")
public class CategoryController {
     @Autowired
    private ICategoryService categoryService;

     @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryDTO> getOne(@PathVariable String uuid) {
        try {
            CategoryDTO category = categoryService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(category);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
     
        return categoryService.create(dto);
    }
    @PutMapping
    public CategoryDTO edit(@RequestBody CategoryDTO dto) {
        return categoryService.edit(dto);
    }
    @DeleteMapping("/{uuid}")
    public CategoryDTO delete(@PathVariable String uuid) {
        return categoryService.delete(UUID.fromString(uuid));
    }


}
