package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.InternDto;

import java.util.List;

public interface InternService {
    InternDto addIntern(InternDto internDto);

    InternDto getInternById(Long id);

    InternDto updateIntern(Long id, InternDto updatedInternDto);

    //    Get all interns
    List<InternDto> getAllInterns();

    void deleteIntern(Long id);

//    InternDto createIntern(InternDto internDto);
}
