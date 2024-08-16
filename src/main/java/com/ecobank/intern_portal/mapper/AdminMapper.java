package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.AdminDto;
import com.ecobank.intern_portal.model.Admins;

public class AdminMapper {

    public static AdminDto mapToAdminDto(Admins admin) {
        return new AdminDto(
                admin.getId(),
                admin.getFirst_name(),
                admin.getLast_name(),
                admin.getEmail(),
                admin.password() // Or use admin.getPassword() if you decide to keep the getter method
        );
    }

    public static Admins mapToAdmin(AdminDto adminDto) {
        return new Admins(
                adminDto.getId(),
                adminDto.getFirst_name(),
                adminDto.getLast_name(),
                adminDto.getEmail(),
                adminDto.getPassword()
        );
    }
}
