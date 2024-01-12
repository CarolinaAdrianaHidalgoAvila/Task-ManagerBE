package com.example.task.categories;

public class CategoryMapper {
    public CategoryDTO toDTO(Category category){
        return new CategoryDTO(category.getUuid(), category.getName());
    }
    public Category toModel(CategoryDTO dto){
        return new Category(dto.getUuid(), dto.getName());
    }
}
