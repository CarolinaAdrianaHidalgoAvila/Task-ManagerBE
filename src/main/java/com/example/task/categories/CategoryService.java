package com.example.task.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.task.exceptions.CategoryNotFoundException;

import java.util.stream.Collectors;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service

public class CategoryService implements ICategoryService {

     @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository
        .findAll()
        .stream()
        .map(category -> mapper.toDTO(category))
        .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getOne(UUID uuid) {
        Category category = new Category(uuid);
        Optional<Category> optionalCategory = categoryRepository.findOne(Example.of(category));

        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException(uuid.toString());
        }

        return mapper.toDTO(optionalCategory.get());
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
       Category category = mapper.toModel(dto);
       Category savedCategory = categoryRepository.save(category);
       return mapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO edit(CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryByUuid(categoryDTO.getUuid());

        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException(categoryDTO.getUuid().toString());
        }

        Category category = optionalCategory.get();
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());

        categoryRepository.save(category);
        return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO delete(UUID uuid) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryByUuid(uuid);

        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException(uuid.toString());
        }

        Category category = optionalCategory.get();
        categoryRepository.delete(category);

        return mapper.toDTO(category);
    }

    
}
