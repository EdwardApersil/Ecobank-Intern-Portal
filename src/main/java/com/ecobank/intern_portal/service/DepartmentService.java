package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    // Implementing DepartmentService methods
    public abstract DepartmentDto createDepartment(DepartmentDto departmentDto);

    public abstract List<DepartmentDto> getAllDepartment();

    public abstract DepartmentDto getDepartmentById(Long id);

    public abstract DepartmentDto updateDepartment(Long id, DepartmentDto updatedDepartmentDto);

    public abstract void deleteDepartment(Long id);
}
