package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.ComplaintDto;

import java.util.List;

public interface ComplaintService {
    ComplaintDto createComplaint(ComplaintDto complaintDto);

    ComplaintDto getComplaintById(Long id);

    List<ComplaintDto> getAllComplaints();

    ComplaintDto updateComplaint(Long id, ComplaintDto updatedComplaint);

    void deleteComplaint(Long id);
}
