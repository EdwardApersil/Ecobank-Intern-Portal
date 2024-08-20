package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.LineManagerDto;

import java.util.List;

//@Service
public interface LineManagerService {
    //    Let's start by creating a new line manager
    LineManagerDto addLineManager(LineManagerDto lineManagerDto);

    LineManagerDto getLineManagerById(Long id);

    List<LineManagerDto> getAllLineManagers();

    LineManagerDto updateLineManager(LineManagerDto updatedLineManagerDto);

    LineManagerDto updateLineManager(Long id, LineManagerDto updatedLineManagerDto);

    void deleteLineManager(Long id);
}
