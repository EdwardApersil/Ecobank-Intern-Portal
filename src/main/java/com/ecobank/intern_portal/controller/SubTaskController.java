package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.SubTaskDto;
import com.ecobank.intern_portal.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intern-portal/v1")
public class SubTaskController {
    // SubTaskController methods

    private final SubTaskService subTaskService;
    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @PostMapping("/sub-tasks")
    public ResponseEntity<SubTaskDto> addSubTask(@RequestBody SubTaskDto subTaskDto) {
        SubTaskDto savedSubTask = subTaskService.addSubTask(subTaskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubTask);
    }

    @GetMapping("/sub-tasks/{id}")
    public ResponseEntity<SubTaskDto> getSubTaskById(@PathVariable("id") Long id) {
        SubTaskDto subTaskById = subTaskService.getSubTaskById(id);
        return ResponseEntity.ok(subTaskById);
    }

    @PutMapping("/sub-tasks/{id}")
    public ResponseEntity<SubTaskDto> updateSubTask(@PathVariable("id") Long id, @RequestBody SubTaskDto updatedSubTaskDto) {
        SubTaskDto updatedSubTask = subTaskService.updateSubTask(id, updatedSubTaskDto);
        return ResponseEntity.ok(updatedSubTask);
    }

    @GetMapping("/sub-tasks")
    public ResponseEntity<List<SubTaskDto>> getAllSubTasks() {
        List<SubTaskDto> subTasks = subTaskService.getAllSubTask();
        return ResponseEntity.ok(subTasks);
    }

    @DeleteMapping("/sub-tasks/{id}")
    public ResponseEntity<Void> deleteSubTask(@PathVariable("id") Long id) {
        subTaskService.deleteSubTask(id);
        return ResponseEntity.noContent().build();
    }
}
