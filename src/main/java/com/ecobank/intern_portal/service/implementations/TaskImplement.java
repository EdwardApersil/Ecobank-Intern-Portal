package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.TaskDto;
import com.ecobank.intern_portal.mapper.TasksMapper;
import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.model.LineManagers;
import com.ecobank.intern_portal.model.Task;
import com.ecobank.intern_portal.repository.InternRespository;
import com.ecobank.intern_portal.repository.LineManagerRespository;
import com.ecobank.intern_portal.repository.TaskRespository;
import com.ecobank.intern_portal.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskImplement implements TaskService {
    private final TaskRespository taskRespository;
    private final InternRespository internRepository;
    private final LineManagerRespository lineManagerRepository;

    @Override
    public TaskDto addTask(String taskDto) {
        return null;
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        if (taskDto == null) {
            throw new IllegalArgumentException("Task object cannot be null");
        }

        // Fetch and check if Intern exists, or handle the logic to save if not
        Intern intern = internRepository.findById(taskDto.getInternId())
                .orElseThrow(() -> new RuntimeException("Intern with id: " + taskDto.getInternId() + " not found"));

        LineManagers lineManager = lineManagerRepository.findById(taskDto.getLineManagerId())
                .orElseThrow(() -> new RuntimeException("LineManager with id: " + taskDto.getLineManagerId() + " not found"));

        Task task = TasksMapper.mapToTask(taskDto);
        task.setIntern(intern);
        task.setLineManager(lineManager);

        Task savedTask = taskRespository.save(task);
        return TasksMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id: " + id + " not found"));
        return TasksMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRespository.findAll();
        return tasks.stream().map(TasksMapper::mapToTaskDto).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto updatedTaskDto) {
        Task task = taskRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id: " + id + " not found"));
        task.setTitle(updatedTaskDto.getTitle());
        task.setDescription(updatedTaskDto.getDescription());
        task.setDueDate(updatedTaskDto.getDueDate());
        task.setStatus(updatedTaskDto.getStatus());
        Task updatedTask = taskRespository.save(task);
        return TasksMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRespository.existsById(id)) {
            throw new RuntimeException("Task with id: " + id + " not found");
        }
        taskRespository.deleteById(id);
    }
}
