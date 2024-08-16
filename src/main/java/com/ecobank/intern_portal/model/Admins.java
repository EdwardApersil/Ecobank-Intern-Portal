package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

//@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Admins")
@Entity
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // You can remove this method if you don't want to expose the password
    public String password() {
        return password;
    }
}
