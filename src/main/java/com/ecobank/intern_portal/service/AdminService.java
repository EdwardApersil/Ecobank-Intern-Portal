package com.ecobank.intern_portal.service;

import com.ecobank.intern_portal.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);

    // Get the admin by its id
    AdminDto getAdminById(Long id);

    // Get all admin list
    List<AdminDto> getAllAdmins();

    // Update the admin by its id
    AdminDto updateAdmin(Long id, AdminDto updatedAdminDto);

    // Delete the admin by its id
    void deleteAdmin(Long id);
}
