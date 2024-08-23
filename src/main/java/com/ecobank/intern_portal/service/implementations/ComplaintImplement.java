package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.ComplaintDto;
import com.ecobank.intern_portal.mapper.ComplaintMapper;
import com.ecobank.intern_portal.model.Admins;
import com.ecobank.intern_portal.model.Complaint;
import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.repository.AdminRespository;
import com.ecobank.intern_portal.repository.ComplaintRespository;
import com.ecobank.intern_portal.repository.InternRespository;
import com.ecobank.intern_portal.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComplaintImplement implements ComplaintService {
    private ComplaintRespository complaintRespository;
    private InternRespository internRepository;
    private AdminRespository adminsRepository;


    @Override
    public ComplaintDto createComplaint(ComplaintDto complaintDto) {
        // First, create the Complaint object from the DTO
        Complaint complaint = ComplaintMapper.mapToComplaint(complaintDto);

        // Set the created_at timestamp
        complaint.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        // Find and set the Intern
        if (complaintDto.getInternId() != null) {
            Intern intern = internRepository.findById(complaintDto.getInternId())
                    .orElseThrow(() -> new RuntimeException("Intern with id: " + complaintDto.getInternId() + " not found"));
            complaint.setIntern(intern);
        }

        // Find and set the Admin
        if (complaintDto.getReviewedBy() != null) {
            Admins reviewedBy = adminsRepository.findById(complaintDto.getReviewedBy())
                    .orElseThrow(() -> new RuntimeException("Admin with id: " + complaintDto.getReviewedBy() + " not found"));
            complaint.setReviewedBy(reviewedBy);
        }

        // Save the complaint
        Complaint savedComplaint = complaintRespository.save(complaint);

        // Map the saved complaint back to DTO and return
        return ComplaintMapper.mapToComplaintDto(savedComplaint);
    }

    @Override
    public ComplaintDto getComplaintById(Long id) {
        Complaint complaint = complaintRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint with id: " + id + " not found"));
        return ComplaintMapper.mapToComplaintDto(complaint);
    }

    @Override
    public List<ComplaintDto> getAllComplaints() {
       List<Complaint> complaint = complaintRespository.findAll();
       return complaint.stream().map(ComplaintMapper::mapToComplaintDto).collect(Collectors.toList());
    }

    @Override
    public ComplaintDto updateComplaint(Long id, ComplaintDto updatedComplaintDto){
        Complaint complaint = complaintRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint with id: " + id + " not found"));
        complaint.setStatus(updatedComplaintDto.getStatus());
        complaint.setCreatedAt(updatedComplaintDto.getCreatedAt());
        complaint.setContent(updatedComplaintDto.getContent());
        Complaint updatedComplaint = complaintRespository.save(complaint);
        return ComplaintMapper.mapToComplaintDto(updatedComplaint);
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRespository.deleteById(id);
    }
}
