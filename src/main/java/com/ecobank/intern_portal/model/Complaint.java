package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "complaints")
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

    @Setter
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne
    @JoinColumn(name = "reviewed_id")
    private Admins reviewedBy;


    public void setCreatedAt(Timestamp createdAt) {
    }

}
