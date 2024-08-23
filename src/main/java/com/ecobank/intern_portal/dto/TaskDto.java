package com.ecobank.intern_portal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    @Getter
    private Long lineManagerId;
    @Getter
    private Long internId;

    public TaskDto(Long id, String title, String description, LocalDate dueDate, String status, Long lineManagerId, Long internId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.lineManagerId = lineManagerId;
        this.internId = internId;
    }

}
