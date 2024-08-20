package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
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
    @JoinColumn(name = "line_manager_id")
    private LineManagers lineManager;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @OneToMany(mappedBy = "task")
    private List<SubTask> subTasks;
}
