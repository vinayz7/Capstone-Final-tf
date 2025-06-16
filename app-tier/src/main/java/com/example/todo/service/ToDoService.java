package com.example.todo.service;

import com.example.todo.dto.ToDoDto;
import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public List<ToDoDto> getAllTodos() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ToDoDto create(ToDoDto dto) {
        ToDo entity = convertToEntity(dto);
        return convertToDto(repository.save(entity));
    }

    private ToDoDto convertToDto(ToDo entity) {
        ToDoDto dto = new ToDoDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setDueDate(entity.getDueDate());
        dto.setCompleted(entity.isCompleted());
        return dto;
    }

    private ToDo convertToEntity(ToDoDto dto) {
        ToDo entity = new ToDo();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setDueDate(dto.getDueDate());
        entity.setCompleted(dto.isCompleted());
        return entity;
    }
}
