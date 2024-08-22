package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "department")
    private List<LineManagers> lineManagers;

    @OneToMany(mappedBy = "department")
    private List<Intern> interns;

    public Department(Object departmentId) {
        this.id = (Long) departmentId;
    }
}

