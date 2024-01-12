package com.example.task.categories;

import java.util.List;


public interface ICategoryService {

    List<CategoryDTO> getAll();

    CategoryDTO create(CategoryDTO dto);

    CategoryDTO edit(CategoryDTO dto);

    CategoryDTO getOne(String uuid);

    CategoryDTO delete(String uuid);
    
}
