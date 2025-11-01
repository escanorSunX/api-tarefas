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

    // 🔹 Criar nova tarefa
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // 🔹 Listar todas as tarefas
    @GetMapping
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    // 🔹 Atualizar uma tarefa existente (PUT)
    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
            .map(tarefa -> {
                tarefa.setNome(tarefaAtualizada.getNome());
                tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
                tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
                return tarefaRepository.save(tarefa);
            })
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
    }

    // 🔹 Deletar uma tarefa pelo ID
    @DeleteMapping("/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        if (!tarefaRepository.existsById(id)) {
            return "Tarefa não encontrada!";
        }
        tarefaRepository.deleteById(id);
        return "Tarefa deletada com sucesso!";
    }
}
