package com.example.todo.controller;

import com.example.todo.dto.ToDoDto;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping
    public List<ToDoDto> getTodos() {
        return service.getAllTodos();
    }

    @PostMapping
    public ToDoDto create(@RequestBody ToDoDto dto) {
        return service.create(dto);
    }
}
