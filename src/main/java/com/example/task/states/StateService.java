package com.example.task.states;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.UUID;

@Service

public class StateService implements IStateService {

     @Autowired
    private StateMapper mapper;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<StateDTO> getAll() {
        return stateRepository
        .findAll()
        .stream()
        .map(task -> mapper.toDTO(task))
        .collect(Collectors.toList());
    }

    @Override
    public StateDTO edit(StateDTO stateDTO) {
        Optional<State> optionalState = stateRepository.getStatusByUuid(stateDTO.getUuid());
        State state = optionalState.get();
        state.setDescription(stateDTO.getDescription());
        state.setName(stateDTO.getName());

        stateRepository.save(state);
        return mapper.toDTO(state);
    }
    @Override
    public StateDTO create(StateDTO dto) {
        State state = mapper.toModel(dto);
        State savedState = stateRepository.save(state);
        return mapper.toDTO(savedState);
    }

    @Override
    public StateDTO getOne(UUID uuid) {
        State state = new State(uuid);
        Optional<State> state1 = stateRepository.findOne(Example.of(state));
        return mapper.toDTO(state1.get());
    }

    @Override
    public StateDTO delete(UUID uuid) {
        Optional<State> optionalState = stateRepository.getStatusByUuid(uuid);
        State state = optionalState.get();
        stateRepository.delete(state);
        return mapper.toDTO(state);
    }
    
}
