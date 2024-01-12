package com.example.task.states;

import java.util.List;

public interface IStateService {

    List<StateDTO> getAll();

    StateDTO create(StateDTO dto);

    StateDTO edit(StateDTO dto);

    StateDTO getOne(String uuid);

    StateDTO delete(String uuid);
}