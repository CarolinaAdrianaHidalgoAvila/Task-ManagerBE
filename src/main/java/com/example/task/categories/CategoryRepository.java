package com.example.task.categories;

import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
//import java.util.UUID;

@Repository
public class CategoryRepository implements ICategoryRepository{

    private static final List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category("Category 1", "1qa32ws"));
        categoryList.add(new Category("Category 2", "2qa32ws"));
        categoryList.add(new Category("Category 3", "3qa32ws"));
    }

    @Override
    public Collection<Category> findAll() {
        return categoryList;
    }

    @Override
    public Category save(Category category) {
        return category;
    }
    @Override
    public void delete(Category deletedCategory) {
       categoryList.remove(deletedCategory);
    }

     @Override
    public Optional<Category> findOne(Example<Category> of) {
        return Optional.ofNullable(categoryList.get(0));
    }
    @Override
    public Category findOneByUuid(String uuid) {
        return new Category("Category 1", uuid);
    }
}
