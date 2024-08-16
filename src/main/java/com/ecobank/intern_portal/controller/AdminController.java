package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.AdminDto;
import com.ecobank.intern_portal.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        AdminDto savedAdmin = adminService.createAdmin(adminDto);
        return ResponseEntity.ok(savedAdmin);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long id) {
        AdminDto adminById = adminService.getAdminById(id);
        return ResponseEntity.ok(adminById);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        List<AdminDto> allAdmins = adminService.getAllAdmins();
        return ResponseEntity.ok(allAdmins);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable("id") Long id, @RequestBody AdminDto updatedAdminDto) {
        AdminDto updatedAdmin = adminService.updateAdmin(id, updatedAdminDto);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }
}
