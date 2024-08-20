package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.InternDto;
import com.ecobank.intern_portal.model.Intern;

public class InternMapper {
    public static InternDto mapToInternDto(Intern internDto) {
        return new InternDto(
                internDto.getId(),
                internDto.getFirst_name(),
                internDto.getLast_name(),
                internDto.getEmail(),
                internDto.password() // Or use intern.getPassword() if you decide to keep the getter method
        );
    }

    public static Intern mapToIntern(InternDto intern) {
        return new Intern(
                intern.getId(),
                intern.getFirst_name(),
                intern.getLast_name(),
                intern.getEmail(),
                intern.getPassword()
        );
    }
}
