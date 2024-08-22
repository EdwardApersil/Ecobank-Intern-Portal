package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.SubTaskDto;

import java.util.List;

public interface SubTaskService {
    SubTaskDto addSubTask(SubTaskDto subTaskDto);

    SubTaskDto getSubTaskById(Long id);

    SubTaskDto updateSubTask(Long id, SubTaskDto updatedSubTaskDto);

    List<SubTaskDto> getAllSubTask();

    void deleteSubTask(Long id);
}
