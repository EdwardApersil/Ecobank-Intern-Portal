package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.TaskDto;
import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.model.LineManagers;
import com.ecobank.intern_portal.model.Task;

public class TasksMapper {

    public static TaskDto mapToTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getLineManagerId(),
                task.getInternId()
        );
    }

    public static Task mapToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(taskDto.getStatus());
        task.setLineManager(new LineManagers(taskDto.getLineManagerId()));
        task.setIntern(new Intern(taskDto.getInternId()));
        return task;
    }

}
