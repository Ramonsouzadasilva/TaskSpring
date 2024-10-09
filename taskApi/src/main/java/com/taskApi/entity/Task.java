package com.taskApi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    public long calculateRemainingDays() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
    }

    public String getRemainingDays() {
        long remainingDays = calculateRemainingDays();
        return remainingDays > 0
                ? remainingDays + " days remaining."
                : "Overdue by " + -remainingDays + " days.";
    }

    public String getStatus() {
        long remainingDays = calculateRemainingDays();
        return remainingDays > 0 ? "Open" : "Overdue";
    }
}
