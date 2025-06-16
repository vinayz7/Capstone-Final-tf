package com.example.todo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
}
