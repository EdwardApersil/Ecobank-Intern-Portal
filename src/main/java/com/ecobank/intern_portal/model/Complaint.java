package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@Entity
@Table(name = "Complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private Admins reviewedBy;

    public Complaint(Long id, String status, String content, java.sql.Timestamp createdAt, Object intern, Object reviewedBy) {
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {

    }
}
