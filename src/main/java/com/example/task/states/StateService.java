package com.example.task.states;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class StateService implements IStateService {

     @Autowired
    private StateMapper mapper;

    @Autowired
    private IStateRepository stateRepository;

    @Override
    public List<StateDTO> getAll() {
        return stateRepository
        .findAll()
        .stream()
        .map(task -> mapper.toDTO(task))
        .collect(Collectors.toList());
    }

    @Override
    public StateDTO create(StateDTO dto) {
        State state = mapper.toModel(dto);
        State savedState = stateRepository.save(state);
        return mapper.toDTO(savedState);
    }

    @Override
    public StateDTO edit(StateDTO dto) {
        State example1 = new State(dto.getUuid());
        Optional<State> optionalState = stateRepository.findOne(Example.of(example1));


        State state = optionalState.get();
        state.setName(dto.getName());

        stateRepository.save(state);
        return mapper.toDTO(state);
    }

    @Override
    public StateDTO getOne(String uuid) {
        State state = getState(uuid);
        return mapper.toDTO(state);
    }

    @Override
    public StateDTO delete(String uuid) {
        State example1 = new State(uuid);
        Optional<State> optionalState = stateRepository.findOne(Example.of(example1));


        State state = optionalState.get();
        stateRepository.delete(state);

        return mapper.toDTO(state);
    }

    private State getState(String uuid) {
        State state = stateRepository.findOneByUuid(uuid);
        return state;
    }
    
}
