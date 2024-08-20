package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.ComplaintDto;
import com.ecobank.intern_portal.model.Complaint;

public class ComplaintMapper {

    public static ComplaintDto mapToComplaintDto(Complaint complaint){
        return new ComplaintDto(
                complaint.getId(),
                complaint.getStatus(),
                complaint.getContent(),
                complaint.getCreatedAt(),
                null,
                null
        );
    }

    public static Complaint mapToComplaint(ComplaintDto complaintDto){
        return new Complaint(
                complaintDto.getId(),
                complaintDto.getStatus(),
                complaintDto.getContent(),
                complaintDto.getCreatedAt(),
                null,
                null
        );
    }

}
