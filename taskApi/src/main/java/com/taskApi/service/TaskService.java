package com.taskApi.service;


import com.taskApi.dto.TaskRequest;
import com.taskApi.dto.TaskResponse;
import com.taskApi.entity.Task;
import com.taskApi.exception.ResourceNotFoundException;
import com.taskApi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponse> listarTarefas() {
        return taskRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse criarTarefa(TaskRequest taskRequest) {
        Task newTask = new Task();
        newTask.setName(taskRequest.name());
        newTask.setDescription(taskRequest.description());
        newTask.setDueDate(taskRequest.dueDate());

        Task savedTask = taskRepository.save(newTask);
        return convertToResponse(savedTask);
    }

    public TaskResponse buscarTarefaPorId(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));
        return convertToResponse(task);
    }

    public void deletarTarefa(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    private TaskResponse convertToResponse(Task task) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new TaskResponse(
                task.getName(),
                task.getDescription(),
                task.getDueDate().format(formatter),
                task.getRemainingDays(),
                task.getStatus()
        );
    }
}
