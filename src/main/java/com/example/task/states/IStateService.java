package com.example.task.states;

import java.util.List;
import java.util.UUID;

public interface IStateService {

    List<StateDTO> getAll();

    StateDTO create(StateDTO dto);

    StateDTO edit(StateDTO dto);

    StateDTO getOne(UUID uuid);

    StateDTO delete(UUID uuid);
}