package com.taskApi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskRequest(String name, String description,
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate dueDate) {
}