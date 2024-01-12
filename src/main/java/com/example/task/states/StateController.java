package com.example.task.states;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private IStateService stateService;

    @GetMapping
    public List<StateDTO> getAll() {
        return stateService.getAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<StateDTO> getOne(@PathVariable String uuid) {
        try {
            StateDTO state = stateService.getOne(uuid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(state);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

     @PostMapping
    public StateDTO create(@RequestBody StateDTO dto) {
        return stateService.create(dto);
    }

    @PutMapping
    public StateDTO edit(@RequestBody StateDTO dto) {
        return stateService.edit(dto);
    }

    @DeleteMapping("/{uuid}")
    public StateDTO delete(@PathVariable String uuid) {
        return stateService.delete(uuid);
    }
}
