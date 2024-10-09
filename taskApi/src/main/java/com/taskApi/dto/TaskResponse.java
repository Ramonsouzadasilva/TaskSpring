package com.taskApi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TaskResponse(String name,
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           String dueDate,
                           String remainingDays,
                           String status) {
}
