package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "Complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}

