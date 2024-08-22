package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.DepartmentDto;
import com.ecobank.intern_portal.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping("/department")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        List<DepartmentDto> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto updatedDepartmentDto) {
        DepartmentDto updatedDepartment = departmentService.updateDepartment(id, updatedDepartmentDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

}
