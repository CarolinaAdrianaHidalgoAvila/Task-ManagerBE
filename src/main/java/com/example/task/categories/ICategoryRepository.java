package com.example.task.categories;
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;
public interface ICategoryRepository {
    Collection<Category> findAll();

   Category save(Category category);

    Optional<Category> findOne(Example<Category> of);

    void delete(Category deletedCategory);
    Category findOneByUuid(String uuid);
}
