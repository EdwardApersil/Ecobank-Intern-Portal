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
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
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
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.password = password;
    }

    public String password() {
        return null;
    }
}
