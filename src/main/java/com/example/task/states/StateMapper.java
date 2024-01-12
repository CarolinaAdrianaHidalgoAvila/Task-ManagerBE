package com.example.task.states;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {

    public StateDTO toDTO(State state) {
        return new StateDTO(state.getUuid(), state.getName());
    }

    public State toModel(StateDTO dto) {
        return new State(dto.getName(), dto.getUuid());
    }
    
}
