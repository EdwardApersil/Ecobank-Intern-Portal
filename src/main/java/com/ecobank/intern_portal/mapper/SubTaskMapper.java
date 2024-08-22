package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.SubTaskDto;
import com.ecobank.intern_portal.model.SubTask;
import com.ecobank.intern_portal.model.Task;
import com.ecobank.intern_portal.model.Intern;

import java.time.LocalDate;

public class SubTaskMapper {

    public static SubTaskDto mapToSubTaskDto(SubTask subTask) {
        return new SubTaskDto(
                subTask.getId(),
                subTask.getTitle(),
                subTask.getDescription(),
                subTask.getStatus(),
                subTask.getTask() != null ? subTask.getTask().getId() : null,
                subTask.getDueDate().toString()
        );
    }

    public static SubTask mapToSubTask(SubTaskDto subTaskDto) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDto.getId());
        subTask.setTitle(subTaskDto.getTitle());
        subTask.setDescription(subTaskDto.getDescription());
        subTask.setStatus(subTaskDto.getStatus());
        subTask.setDueDate(LocalDate.parse(subTaskDto.getDueDate()));
        if (subTaskDto.getTaskId() != null) {
            subTask.setTask(new Task(subTaskDto.getTaskId()));
        }
        return subTask;
    }
}
