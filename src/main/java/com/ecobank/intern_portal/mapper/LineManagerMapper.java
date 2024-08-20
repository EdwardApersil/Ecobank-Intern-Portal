package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.LineManagerDto;
import com.ecobank.intern_portal.model.LineManagers;

public class LineManagerMapper {
    public static LineManagerDto mapToLineManagerDto(LineManagers lineManager) {
        return new LineManagerDto(
                lineManager.getId(),
                lineManager.getFirstName(),
                lineManager.getLastName(),
                lineManager.getEmail(),
                lineManager.password()
        );
    }

    public static LineManagers mapToLineManager(LineManagerDto lineManagerDto) {
        return new LineManagers(
                lineManagerDto.getId(),
                lineManagerDto.getFirstName(),
                lineManagerDto.getLastName(),
                lineManagerDto.getEmail(),
                lineManagerDto.getPassword()
        );
    }

}
