package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.TaskDto;
import com.ecobank.intern_portal.mapper.TasksMapper;
import com.ecobank.intern_portal.model.Task;
import com.ecobank.intern_portal.repository.TaskRespository;
import com.ecobank.intern_portal.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskImplement implements TaskService {
    private TaskRespository taskRepository;

    @Override
    public TaskDto addTask(String taskDto) {
        return null;
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        if (taskDto == null) {
            throw new IllegalArgumentException("Task object cannot be null");
        }
        Task task = TasksMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TasksMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id: " + id + " not found"));
        return TasksMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TasksMapper::mapToTaskDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto updatedTaskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id: " + id + " not found"));
        task.setTitle(updatedTaskDto.getTitle());
        task.setDescription(updatedTaskDto.getDescription());
        task.setDueDate(updatedTaskDto.getDueDate());
        task.setStatus(updatedTaskDto.getStatus());
        Task updatedTask = taskRepository.save(task);
        return TasksMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task with id: " + id + " not found");
        }
        taskRepository.deleteById(id);
    }
}
