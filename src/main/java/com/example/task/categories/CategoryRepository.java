package com.example.task.categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import java.util.UUID;
public interface CategoryRepository extends JpaRepository<Category, Long>{
  
    List<Category> findAllByUuidIn(List<UUID> uuids);
    Optional<Category> getCategoryByUuid(UUID uuid);
}
