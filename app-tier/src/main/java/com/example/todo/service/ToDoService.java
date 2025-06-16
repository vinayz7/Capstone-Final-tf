package com.example.todo.service;

import com.example.todo.dto.ToDoDto;
import java.util.List;

public interface ToDoService {
    List<ToDoDto> getAllTodos();
    ToDoDto create(ToDoDto dto);
    ToDoDto getTodoById(Long id);
    ToDoDto update(ToDoDto dto);
    void delete(Long id);
}
