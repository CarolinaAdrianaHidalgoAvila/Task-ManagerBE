package com.example.task.states;

import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
//import java.util.UUID;

@Component
public class StateRepository implements IStateRepository {

    private static final List<State> stateList = new ArrayList<>();

    static {
        stateList.add(new State("state 1", "1wsxedc"));
        stateList.add(new State("state 2",  "2wsxedcrf"));
        stateList.add(new State("state 3", "3wsxedrf"));
    }

    @Override
    public Collection<State> findAll() {
        return stateList;
    }

    @Override
    public State save(State state) {
        return state;
    }

    @Override
    public Optional<State> findOne(Example<State> of) {
        return Optional.ofNullable(stateList.get(0));
    }

    public void delete(State deletedState) {
        stateList.remove(deletedState);
    }

    @Override
    public State findOneByUuid(String uuid) {
        return new State("State 1",uuid);
    }

}
