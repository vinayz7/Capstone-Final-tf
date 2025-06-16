package com.example.todo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    // Getters and setters
}
