package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.ComplaintDto;
import com.ecobank.intern_portal.mapper.ComplaintMapper;
import com.ecobank.intern_portal.model.Complaint;
import com.ecobank.intern_portal.repository.ComplaintRespository;
import com.ecobank.intern_portal.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComplaintImplement implements ComplaintService {
    private ComplaintRespository complaintRespository;


    @Override
    public ComplaintDto createComplaint(ComplaintDto complaintDto){
        Complaint complaint = ComplaintMapper.mapToComplaint(complaintDto);
        Complaint savedComplaint = complaintRespository.save(complaint);
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
