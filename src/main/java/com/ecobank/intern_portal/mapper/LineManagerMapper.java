package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.LineManagerDto;
import com.ecobank.intern_portal.model.Department;
import com.ecobank.intern_portal.model.LineManagers;

import javax.sound.sampled.Line;

public class LineManagerMapper {
    public static LineManagerDto mapToLineManagerDto(LineManagers lineManager) {
        if (lineManager == null) {
            return null;
        }
        return new LineManagerDto(
                lineManager.getId(),
                lineManager.getFirstName(),
                lineManager.getLastName(),
                lineManager.getEmail(),
                lineManager.getPassword(),
                lineManager.getDepartment() != null ? lineManager.getDepartment().getId() : null
        );
    }

    public static LineManagers mapToLineManager(LineManagerDto dto) {
        LineManagers lineManager = new LineManagers();
        lineManager.setId(dto.getId());
        lineManager.setFirstName(dto.getFirstName());
        lineManager.setLastName(dto.getLastName());
        lineManager.setEmail(dto.getEmail());
        lineManager.setPassword(dto.getPassword());
        lineManager.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        if (dto.getDepartmentId() != null) {
            Department department = new Department();
            department.setId(dto.getDepartmentId());
            lineManager.setDepartment(department);
        }

        return lineManager;
    }

}
