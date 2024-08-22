package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.DepartmentDto;
import com.ecobank.intern_portal.mapper.DepartmentMapper;
import com.ecobank.intern_portal.model.Department;
import com.ecobank.intern_portal.repository.DepartmentRespository;
import com.ecobank.intern_portal.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentImplement implements DepartmentService {

    private DepartmentRespository departmentRespository;

    // Implementing DepartmentService methods

    /**
     * Creates a new department.
     *
     * @param departmentDto The department data transfer object to be created.
     * @return The created department data transfer object.
     */
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        Department department  = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRespository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    /**
     * Retrieves all departments.
     *
     * @return A list of department data transfer objects.
     */
    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRespository.findAll();
        return departments.stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a department by its id.
     *
     * @param id The id of the department to be retrieved.
     * @return The department data transfer object with the given id.
     * @throws RuntimeException If no department is found with the given id.
     */
    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRespository.findById(id)
               .orElseThrow(() -> new RuntimeException("Department with id: " + id + " not found"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }
    
    /**
     * Updates a department by its id.
     *
     * @param id The id of the department to be updated.
     * @param updatedDepartmentDto The updated department data transfer object.
     * @return The updated department data transfer object.
     * @throws RuntimeException If no department is found with the given id.
     */
    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto updatedDepartmentDto) {
        Department department = departmentRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department with id: " + id + " not found"));
        department.setName(updatedDepartmentDto.getName());
        department.setDescription(updatedDepartmentDto.getDescription());
        Department updatedDepartment = departmentRespository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }
    
    /**
     * Deletes a department by its id.
     *
     * @param id The id of the department to be deleted.
     */
    @Override
    public void deleteDepartment(Long id) {
        departmentRespository.deleteById(id);
    }
}
