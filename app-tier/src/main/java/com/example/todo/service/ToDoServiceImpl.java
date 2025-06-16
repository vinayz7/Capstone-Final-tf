package com.example.todo.service;

import com.example.todo.dto.ToDoDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository repository;

    private ToDoDto convert(ToDo todo) {
        ToDoDto dto = new ToDoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setDueDate(todo.getDueDate());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }

    private ToDo toEntity(ToDoDto dto) {
        ToDo todo = new ToDo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setDueDate(dto.getDueDate());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }

    @Override
    public List<ToDoDto> getAllTodos() {
        return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public ToDoDto create(ToDoDto dto) {
        return convert(repository.save(toEntity(dto)));
    }

    @Override
    public ToDoDto getTodoById(Long id) {
        return repository.findById(id).map(this::convert).orElse(null);
    }

    @Override
    public ToDoDto update(ToDoDto dto) {
        return convert(repository.save(toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
