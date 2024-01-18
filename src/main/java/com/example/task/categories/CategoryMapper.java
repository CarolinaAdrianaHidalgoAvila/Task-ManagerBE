package com.example.task.categories;

public class CategoryMapper {
    public CategoryDTO toDTO(Category category){
        return new CategoryDTO(category.getUuid(), category.getName(), category.getDescription());
    }
    public Category toModel(CategoryDTO dto){
        return new Category(dto.getUuid(), dto.getName(),dto.getDescription());
    }
}
