package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.LineManagerDto;
import com.ecobank.intern_portal.model.LineManagers;

public class LineManagerMapper {
    public static LineManagerDto mapToLineManagerDto(LineManagers lineManager) {
        return new LineManagerDto(
                lineManager.getId(),
                lineManager.getFirst_name(),
                lineManager.getLast_name(),
                lineManager.getEmail(),
                lineManager.password()
        );
    }

    public static LineManagers mapToLineManager(LineManagerDto lineManagerDto) {
        return new LineManagers(
                lineManagerDto.getId(),
                lineManagerDto.getFirst_name(),
                lineManagerDto.getLast_name(),
                lineManagerDto.getEmail(),
                lineManagerDto.getPassword()
        );
    }

}
