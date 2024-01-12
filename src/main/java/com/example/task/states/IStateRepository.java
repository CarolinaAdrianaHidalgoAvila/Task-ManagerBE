package com.example.task.states;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Example;

public interface IStateRepository {

    Collection<State> findAll();

    State save(State state);

    Optional<State> findOne(Example<State> of);

    void delete(State state);

    State findOneByUuid(String uuid);
    
}
