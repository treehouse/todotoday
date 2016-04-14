package com.teamtreehouse.todotoday.web.controller;

import com.teamtreehouse.todotoday.model.Task;
import com.teamtreehouse.todotoday.model.User;
import com.teamtreehouse.todotoday.service.TaskService;
import com.teamtreehouse.todotoday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/todo"})
    public String taskList(Model model) {
        Iterable<Task> tasks = taskService.findAll();
        model.addAttribute("tasks",tasks);
        model.addAttribute("newTask", new Task());
        return "todo";
    }

    @RequestMapping(path = "/mark", method = RequestMethod.POST)
    public String toggleComplete(@RequestParam Long id) {
        Task task = taskService.findOne(id);
        taskService.toggleComplete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public String addTask(@ModelAttribute Task task, Principal principal) {
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        task.setUser(user);
        taskService.save(task);
        return "redirect:/";
    }
}