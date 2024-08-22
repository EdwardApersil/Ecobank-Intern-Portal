package com.ecobank.intern_portal.dto;

import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.model.LineManagers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private String description;
    private List<LineManagers> lineManagers = new ArrayList<>();
    @Getter
    private List<Intern> interns = new ArrayList<>();

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
