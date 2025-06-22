package com.example.todo.dto;

import com.example.todo.entity.Priority;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ToDoDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Priority priority;
}
