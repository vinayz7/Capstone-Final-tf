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

    public List<ToDoDto> getAllTasks() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ToDoDto getTask(Long id) {
        return repository.findById(id).map(this::convertToDto).orElse(null);
    }

    public ToDoDto createTask(ToDoDto dto) {
        ToDo task = convertToEntity(dto);
        return convertToDto(repository.save(task));
    }

    public ToDoDto updateTask(Long id, ToDoDto dto) {
        ToDo task = repository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setDueDate(dto.getDueDate());
            task.setCompleted(dto.isCompleted());
            return convertToDto(repository.save(task));
        }
        return null;
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
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
