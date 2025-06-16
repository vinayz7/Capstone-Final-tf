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
    private ToDoService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", service.getAllTodos());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("task", new ToDoDto());
        return "add-task";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("task") ToDoDto dto) {
        service.create(dto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("task", service.getTodoById(id));
        return "edit-task";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("task") ToDoDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
