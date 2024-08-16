package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "lineManagers")
@Entity
public class LineManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    public String password() {
        return password;
    }

}
