package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.TaskDto;
import com.ecobank.intern_portal.errorResponse.TaskErrorResponse;
import com.ecobank.intern_portal.model.Task;
import com.ecobank.intern_portal.repository.TaskRespository;
import com.ecobank.intern_portal.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.ErrorResponse;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class TaskController {
    // TaskController methods
//    private TaskRespository taskRespository;
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.addTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") Long id, HttpServletRequest request) {
        TaskDto taskById = taskService.getTaskById(id);

        if (taskById == null) {
            ErrorResponse errorResponse = (ErrorResponse) new TaskErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Task Not Found",
                    "The task with the given ID does not exist.",
                    request.getRequestURI(),
                    String.valueOf(System.currentTimeMillis())
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(taskById);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long id, @RequestBody TaskDto updatedTaskDto) {
        TaskDto updatedTask = taskService.updateTask(id, updatedTaskDto);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        TaskDto taskById = taskService.getTaskById(id);
        
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
