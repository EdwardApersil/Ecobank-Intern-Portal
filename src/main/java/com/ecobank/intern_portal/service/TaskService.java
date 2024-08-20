package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(String taskDto);

    TaskDto addTask(TaskDto taskDto);

    TaskDto getTaskById(Long id);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long id, TaskDto updatedTaskDto);

    void deleteTask(Long id);
}
