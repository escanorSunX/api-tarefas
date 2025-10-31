package com.example.api_tarefas.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.api_tarefas.model.Tarefa;
import com.example.api_tarefas.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository tarefaRepository;

    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }
}