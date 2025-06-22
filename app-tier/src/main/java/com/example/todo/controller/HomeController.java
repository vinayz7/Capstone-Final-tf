package com.example.todo.controller;

import com.example.todo.dto.ToDoDto;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ToDoService todoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllToDos());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("todo", new ToDoDto());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute("todo") ToDoDto todoDto) {
        todoService.saveToDo(todoDto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, Model model) {
        ToDoDto todo = todoService.getToDoById(id);
        model.addAttribute("todo", todo);
        return "edit-task";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute("todo") ToDoDto todoDto) {
        todoDto.setId(id);
        todoService.updateToDo(todoDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteToDo(id);
        return "redirect:/";
    }
}
