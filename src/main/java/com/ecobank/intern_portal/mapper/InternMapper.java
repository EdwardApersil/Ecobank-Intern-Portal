package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.InternDto;
import com.ecobank.intern_portal.model.Department;
import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.model.LineManagers;

public class InternMapper {

    public static InternDto mapToInternDto(Intern intern) {
        return new InternDto(
                intern.getId(),
                intern.getFirstName(),
                intern.getLastName(),
                intern.getEmail(),
                intern.getPassword(),
                intern.getDepartment() != null ? intern.getDepartment().getId() : null,
                intern.getLineManager() != null ? intern.getLineManager().getId() : null
        );
    }

    public static Intern mapToIntern(InternDto internDto) {
        Intern intern = new Intern(
                internDto.getId(),
                internDto.getFirstName(),
                internDto.getLastName(),
                internDto.getEmail(),
                internDto.getPassword()
        );

        if (internDto.getDepartmentId() != null) {
            intern.setDepartment(new Department(internDto.getDepartmentId()));
        }

        if (internDto.getLineManagerId() != null) {
            intern.setLineManager(new LineManagers(internDto.getLineManagerId()));
        }

        return intern;
    }
}
