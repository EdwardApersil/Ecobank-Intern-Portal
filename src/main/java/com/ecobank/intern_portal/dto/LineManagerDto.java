package com.ecobank.intern_portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class LineManagerDto {
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String password;
    @JsonProperty("department_id")
    private Long departmentId;


    public LineManagerDto(Long id, String firstName, String lastName, String email, String password, Long aLong){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
//
//    public LineManagerDto(Long id, String firstName, String lastName, String email, String password, Long aLong) {
//    }
}
