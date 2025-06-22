package com.example.todo.service;

import com.example.todo.dto.ToDoDto;

import java.util.List;

public interface ToDoService {
    void saveToDo(ToDoDto dto);
    void updateToDo(ToDoDto dto);
    ToDoDto getToDoById(Long id);
    List<ToDoDto> getAllToDos();
    void deleteToDo(Long id);
}
