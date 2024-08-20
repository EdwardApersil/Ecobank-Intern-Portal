package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * This class represents a Line Manager in the Ecobank Intern Portal application.
 * It is annotated with JPA annotations to map it to a database table named "line_managers".
 *
 * @author Edward Apersil
 * @version 1.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")
@Table(name = "line_managers")
@Entity
public class LineManagers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 60, unique = true)  // Assuming bcrypt hashing
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "lineManager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Intern> interns;

    @OneToMany(mappedBy = "lineManager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    public LineManagers(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String password() {
        return null;
    }
}