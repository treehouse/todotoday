package com.teamtreehouse.todotoday.service;

import com.teamtreehouse.todotoday.model.Task;

public interface TaskService {
    Iterable<Task> findAll();
    Task findOne(Long id);
    void toggleComplete(Long id);
    void save(Task task);
}
