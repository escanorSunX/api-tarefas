package com.example.api_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Aqui você pode adicionar consultas customizadas, se precisar
}