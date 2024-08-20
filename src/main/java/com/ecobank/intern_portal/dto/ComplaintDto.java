package com.ecobank.intern_portal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDto {
    private Long id;
    private String content;
    private String status;
    private InternDto intern;
    private AdminDto reviewedBy;
    private Timestamp createdAt;

    public ComplaintDto(String content, String status, Long id){
        this.content = content;
        this.status = status;
        this.id = id;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.intern = null;
        this.reviewedBy = null;
    }

    public ComplaintDto(Long id, String status, String content, java.security.Timestamp createdAt) {
    }

    public ComplaintDto(Long id, String status, String content, java.security.Timestamp createdAt, Object reviewedBy, Object createdAt1) {
    }
}
