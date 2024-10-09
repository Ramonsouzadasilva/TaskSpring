package com.taskApi.controller;


import com.taskApi.dto.TaskRequest;
import com.taskApi.dto.TaskResponse;
import com.taskApi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Validated
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listarTarefas() {
        List<TaskResponse> tasks = taskService.listarTarefas();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> criarTarefa(@Valid @RequestBody TaskRequest taskRequest) {
        TaskResponse response = taskService.criarTarefa(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> buscarTarefaPorId(@PathVariable Long id) {
        TaskResponse response = taskService.buscarTarefaPorId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        taskService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
