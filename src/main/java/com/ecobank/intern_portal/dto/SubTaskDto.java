package com.ecobank.intern_portal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.net.ssl.SSLSession;
import java.time.LocalDate;

@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class SubTaskDto {

    private Long id;
    private String title;
    private String description;
    private String status;
    private Long taskId;
    private String dueDate;

    public SubTaskDto(Long id, String title, String description, String status, Long aLong, String string) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.taskId = aLong;
        this.dueDate = string;
    }
}
