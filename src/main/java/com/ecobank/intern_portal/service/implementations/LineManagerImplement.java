package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.LineManagerDto;
import com.ecobank.intern_portal.mapper.LineManagerMapper;
import com.ecobank.intern_portal.model.LineManagers;
import com.ecobank.intern_portal.repository.LineManagerRespository;
import com.ecobank.intern_portal.service.LineManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LineManagerImplement implements LineManagerService {
//    This service implementation handles the creation of a new line manager
//    deleting a line manager, updating a line manager, and getting a line manager by id
//    The admin should be able to perform all these operations
//    The line manager should be able to update his/her details
//    The line manager should be able to view his/her details
//    The line manager should be able to view all interns under him/her

    public LineManagerRespository lineManagerRespository;

//    Let's start by creating a new line manager
    @Override
    public LineManagerDto addLineManager(LineManagerDto lineManagerDto) {
        // Implement the logic to create a new line manager
        LineManagers lineManager = LineManagerMapper.mapToLineManager(lineManagerDto);
        // Save the line manager to the database
        LineManagers savedLineManager = lineManagerRespository.save(lineManager);
        return LineManagerMapper.mapToLineManagerDto(savedLineManager);
    }

    @Override
    public LineManagerDto getLineManagerById(Long id) {
        // Implement the logic to get a line manager by id
        LineManagers lineManager = lineManagerRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Line Manager with id: " + id + " not found"));
        return LineManagerMapper.mapToLineManagerDto(lineManager);
    }

    @Override
    public List<LineManagerDto> getAllLineManagers() {
        // Implement the logic to get all line managers
        List<LineManagers> lineManagers = lineManagerRespository.findAll();
        return lineManagers.stream().map(LineManagerMapper::mapToLineManagerDto).collect(Collectors.toList());
    }

    @Override
    public LineManagerDto updateLineManager(LineManagerDto updatedLineManagerDto) {
        return null;
    }

    @Override
    public LineManagerDto updateLineManager(Long id, LineManagerDto updatedLineManagerDto) {
        // Implement the logic to update a line manager by id
        LineManagers lineManager = lineManagerRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Line Manager with id: " + id + " not found"));
        lineManager.setFirst_name(updatedLineManagerDto.getFirst_name());
        lineManager.setLast_name(updatedLineManagerDto.getLast_name());
        lineManager.setEmail(updatedLineManagerDto.getEmail());
        lineManager.setPassword(updatedLineManagerDto.getPassword());
        LineManagers updatedLineManager = lineManagerRespository.save(lineManager);
        return LineManagerMapper.mapToLineManagerDto(updatedLineManager);
    }

    @Override
    public void deleteLineManager(Long id) {
        // Implement the logic to delete a line manager by id
        lineManagerRespository.deleteById(id);
    }





}
