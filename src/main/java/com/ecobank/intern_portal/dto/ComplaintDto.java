package com.ecobank.intern_portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplaintDto {
    private Long id;
    private String content;
    private String status;

    @JsonProperty("intern_id")
    private Long internId;

    @JsonProperty("reviewed_id")
    private Long reviewedBy;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    public ComplaintDto(Long id, String content, String status, Timestamp createdAt, Long reviewedBy, Long aLong) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.internId = aLong;
        this.reviewedBy = reviewedBy;
        this.createdAt = createdAt;
    }

    public ComplaintDto(Long id, String content, String status, java.security.Timestamp createdAt, Long aLong, Long aLong1) {

    }
}
