package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.ComplaintDto;
import com.ecobank.intern_portal.model.Admins;
import com.ecobank.intern_portal.model.Complaint;
import com.ecobank.intern_portal.model.Intern;

/**
 * This class provides methods to map {@link Complaint} objects to {@link ComplaintDto} objects and vice versa.
 */
public class ComplaintMapper {

    /**
     * Maps a {@link Complaint} object to a {@link ComplaintDto} object.
     *
     * @param complaint The {@link Complaint} object to be mapped.
     * @return A {@link ComplaintDto} object containing the mapped data.
     */
    public static ComplaintDto mapToComplaintDto(Complaint complaint){
        return new ComplaintDto(
                complaint.getId(),
                complaint.getContent(),
                complaint.getStatus(),
                complaint.getCreatedAt(),
                complaint.getIntern() != null ? complaint.getIntern().getId() : null,
                complaint.getReviewedBy() != null ? complaint.getReviewedBy().getId() : null
        );
    }

    /**
     * Maps a {@link ComplaintDto} object to a {@link Complaint} object.
     *
     * @param complaintDto The {@link ComplaintDto} object to be mapped.
     * @return A {@link Complaint} object containing the mapped data.
     */
    public static Complaint mapToComplaint(ComplaintDto complaintDto){
        Complaint complaint = new Complaint();
        complaint.setId(complaintDto.getId());
        complaint.setContent(complaintDto.getContent());
        complaint.setStatus(complaintDto.getStatus());
        complaint.setCreatedAt(complaintDto.getCreatedAt());

        if (complaintDto.getInternId() != null) {
            Intern intern = new Intern();
            intern.setId(complaintDto.getInternId());
            complaint.setIntern(intern);
        }

        if (complaintDto.getReviewedBy() != null) {
            Admins reviewedBy = new Admins();
            reviewedBy.setId(complaintDto.getReviewedBy());
            complaint.setReviewedBy(reviewedBy);
        }

        return complaint;
    }
}
