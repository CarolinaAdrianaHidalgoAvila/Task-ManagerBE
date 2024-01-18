package com.example.task.categories;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {

    List<CategoryDTO> getAll();

    CategoryDTO create(CategoryDTO dto);

    CategoryDTO edit(CategoryDTO dto);

    CategoryDTO getOne(UUID uuid);

    CategoryDTO delete(UUID uuid);
    
}
