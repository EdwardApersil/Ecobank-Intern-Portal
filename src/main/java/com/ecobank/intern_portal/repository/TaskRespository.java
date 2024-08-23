package com.ecobank.intern_portal.repository;

import com.ecobank.intern_portal.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRespository extends JpaRepository<Task, Long> {

}
