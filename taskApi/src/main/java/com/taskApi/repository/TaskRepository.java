package com.taskApi.repository;

import com.taskApi.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}