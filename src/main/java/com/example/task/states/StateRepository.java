package com.example.task.states;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StateRepository extends JpaRepository<State, Long>  {

  List<State> findAllByUuidIn(List<UUID> uuids);
    Optional<State> getStatusByUuid(UUID uuid);
    
}
