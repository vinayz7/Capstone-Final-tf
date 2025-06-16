package com.example.todo.controller;

import com.example.todo.dto.ToDoDto;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ToDoController {
    @Autowired
    private ToDoService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("task", new ToDoDto());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") ToDoDto dto) {
        service.createTask(dto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", service.getTask(id));
        return "edit-task";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") ToDoDto dto) {
        service.updateTask(id, dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "redirect:/";
    }
}
