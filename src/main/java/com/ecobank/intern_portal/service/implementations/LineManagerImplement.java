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

/**
 * This service implementation handles the creation of a new line manager,
 * deleting a line manager, updating a line manager, and getting a line manager by id.
 * The admin should be able to perform all these operations.
 * The line manager should be able to update his/her details.
 * The line manager should be able to view his/her details.
 * The line manager should be able to view all interns under him/her.
 */
@Service
@AllArgsConstructor
public class LineManagerImplement implements LineManagerService {

    /**
     * Repository for accessing LineManager data.
     */
    public LineManagerRespository lineManagerRespository;

    /**
     * Adds a new line manager to the system.
     *
     * @param lineManagerDto The DTO containing the new line manager's details.
     * @return The DTO of the newly created line manager.
     * @throws IllegalArgumentException If the first name, last name, or email is missing.
     */
    @Override
    public LineManagerDto addLineManager(LineManagerDto lineManagerDto) {
        LineManagers lineManager = LineManagerMapper.mapToLineManager(lineManagerDto);
        if (lineManager.getFirstName() == null || lineManager.getLastName() == null || lineManager.getEmail() == null) {
            throw new IllegalArgumentException("First name, last name, and email are required");
        }
        LineManagers savedLineManager = lineManagerRespository.save(lineManager);
        return LineManagerMapper.mapToLineManagerDto(savedLineManager);
    }

    /**
     * Retrieves a line manager by their unique identifier.
     *
     * @param id The unique identifier of the line manager.
     * @return The DTO of the requested line manager.
     * @throws RuntimeException If the line manager with the given id is not found.
     */
    @Override
    public LineManagerDto getLineManagerById(Long id) {
        LineManagers lineManager = lineManagerRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Line Manager with id: " + id + " not found"));
        return LineManagerMapper.mapToLineManagerDto(lineManager);
    }

    /**
     * Retrieves all line managers.
     *
     * @return A list of DTOs representing all line managers.
     */
    @Override
    public List<LineManagerDto> getAllLineManagers() {
        List<LineManagers> lineManagers = lineManagerRespository.findAll();
        return lineManagers.stream().map(LineManagerMapper::mapToLineManagerDto).collect(Collectors.toList());
    }

    /**
     * Updates a line manager's details.
     *
     * @param updatedLineManagerDto The DTO containing the updated line manager's details.
     * @return The DTO of the updated line manager.
     */
    @Override
    public LineManagerDto updateLineManager(LineManagerDto updatedLineManagerDto) {
        return null;
    }

    /**
     * Updates a line manager's details by their unique identifier.
     *
     * @param id The unique identifier of the line manager.
     * @param updatedLineManagerDto The DTO containing the updated line manager's details.
     * @return The DTO of the updated line manager.
     * @throws RuntimeException If the line manager with the given id is not found.
     */
    @Override
    public LineManagerDto updateLineManager(Long id, LineManagerDto updatedLineManagerDto) {
        LineManagers lineManager = lineManagerRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Line Manager with id: " + id + " not found"));
        lineManager.setFirstName(updatedLineManagerDto.getFirstName());
        lineManager.setLastName(updatedLineManagerDto.getLastName());
        lineManager.setEmail(updatedLineManagerDto.getEmail());
        lineManager.setPassword(updatedLineManagerDto.getPassword());
        LineManagers updatedLineManager = lineManagerRespository.save(lineManager);
        return LineManagerMapper.mapToLineManagerDto(updatedLineManager);
    }

    /**
     * Deletes a line manager by their unique identifier.
     *
     * @param id The unique identifier of the line manager.
     */
    @Override
    public void deleteLineManager(Long id) {
        lineManagerRespository.deleteById(id);
    }
}
