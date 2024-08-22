package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.SubTaskDto;
import com.ecobank.intern_portal.mapper.SubTaskMapper;
import com.ecobank.intern_portal.model.SubTask;
import com.ecobank.intern_portal.repository.SubTaskRespository;
import com.ecobank.intern_portal.service.SubTaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubTaskImplement implements SubTaskService {
    private final SubTaskRespository subTaskRespository;

    @Override
    public SubTaskDto addSubTask(SubTaskDto subTaskDto) {
        SubTask subTask = SubTaskMapper.mapToSubTask(subTaskDto);
        SubTask savedSubTask = subTaskRespository.save(subTask);
        return SubTaskMapper.mapToSubTaskDto(savedSubTask);
    }

    @Override
    public SubTaskDto getSubTaskById(Long id) {
        SubTask subTask = subTaskRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubTask with id: " + id + " not found"));
        return SubTaskMapper.mapToSubTaskDto(subTask);
    }

    @Override
    public SubTaskDto updateSubTask(Long id, SubTaskDto updatedSubTaskDto) {
        SubTask subTask = subTaskRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubTask with id: " + id + " not found"));
        subTask.setTitle(updatedSubTaskDto.getTitle());
        subTask.setDescription(updatedSubTaskDto.getDescription());
        subTask.setStatus(updatedSubTaskDto.getStatus());
        subTask.setDueDate(LocalDate.parse(updatedSubTaskDto.getDueDate()));
        SubTask updatedSubTask = subTaskRespository.save(subTask);
        return SubTaskMapper.mapToSubTaskDto(updatedSubTask);
    }

    @Override
    public List<SubTaskDto> getAllSubTask() {
        List<SubTask> subTasks = subTaskRespository.findAll();
        return subTasks.stream()
                .map(SubTaskMapper::mapToSubTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubTask(Long id) {
        if (!subTaskRespository.existsById(id)) {
            throw new RuntimeException("SubTask with id: " + id + " not found");
        }
        subTaskRespository.deleteById(id);
    }
}
