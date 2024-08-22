package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@Getter
@Setter
@Table(name = "interns")
@Entity
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName; // Changed to camelCase

    @Column(name = "last_name", nullable = false)
    private String lastName; // Changed to camelCase

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "line_manager_id")
    private LineManagers lineManager;

    @OneToMany(mappedBy = "intern")
    private List<Task> tasks;

    @OneToMany(mappedBy = "intern")
    private List<Complaint> complaints;

    public Intern(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Intern(Long id, String firstName, String lastName, String email, String password, Long departmentId, Long lineManagerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.department = new Department(departmentId);
        this.lineManager = new LineManagers(lineManagerId);
    }

    public Intern(Long internId) {
        this.id = internId;
    }

    public void setIntern(Intern intern) {
        this.id = intern.getId();
    }
}
