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
    private ToDoRepository repo;

    @Override
    public void saveToDo(ToDoDto dto) {
        ToDo todo = mapToEntity(dto);
        repo.save(todo);
    }

    @Override
    public void updateToDo(ToDoDto dto) {
        ToDo todo = mapToEntity(dto);
        repo.save(todo); // repo.save will do insert or update
    }

    @Override
    public ToDoDto getToDoById(Long id) {
        return repo.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    @Override
    public List<ToDoDto> getAllToDos() {
        return repo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteToDo(Long id) {
        repo.deleteById(id);
    }

    private ToDo mapToEntity(ToDoDto dto) {
        ToDo todo = new ToDo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setPriority(dto.getPriority());
        todo.setDueDate(dto.getDueDate());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }

    private ToDoDto mapToDto(ToDo todo) {
        ToDoDto dto = new ToDoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setPriority(todo.getPriority());
        dto.setDueDate(todo.getDueDate());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }
}
