package com.ecobank.intern_portal.repository;

import com.ecobank.intern_portal.dto.DepartmentDto;
import com.ecobank.intern_portal.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Department, Long> {

}
