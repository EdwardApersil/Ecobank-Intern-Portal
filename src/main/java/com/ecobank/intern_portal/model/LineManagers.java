package com.ecobank.intern_portal.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class represents a Line Manager in the Ecobank Intern Portal application.
 * It is annotated with JPA annotations to map it to a database table named "lineManagers".
 *
 * @author Edward Apersil
 * @version 1.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "lineManagers")
@Entity
public class LineManagers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the Line Manager.
     */
    @Column(name = "first_name")
    private String first_name;

    /**
     * The last name of the Line Manager.
     */
    @Column(name = "last_name")
    private String last_name;

    /**
     * The email address of the Line Manager.
     */
    @Column(name = "email")
    private String email;

    /**
     * The password of the Line Manager.
     *
     * @return the password of the Line Manager
     */
    @Column(name = "password")
    private String password;

    /**
     * Returns the password of the Line Manager.
     *
     * @return the password of the Line Manager
     */
    public String password() {
        return password;
    }

}
