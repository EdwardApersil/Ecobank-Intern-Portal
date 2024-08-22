package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

//@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
@Table(name = "Admins")
@Entity
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    public String password() {
        return password;
    }


}
