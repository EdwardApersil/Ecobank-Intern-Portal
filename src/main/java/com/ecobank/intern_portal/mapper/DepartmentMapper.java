package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.DepartmentDto;
import com.ecobank.intern_portal.model.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getLineManagers().stream().toList(),
                department.getInterns()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getLineManagers().stream().toList(),
                departmentDto.getInterns()
        );
    }
}
