package com.ecobank.intern_portal.mapper;

import com.ecobank.intern_portal.dto.AdminDto;
import com.ecobank.intern_portal.model.Admins;

/**
 * This class provides methods to map between {@link Admins} and {@link AdminDto} objects.
 */
public class AdminMapper {

    /**
     * Maps an {@link Admins} object to an {@link AdminDto} object.
     *
     * @param admin The {@link Admins} object to be mapped.
     * @return An {@link AdminDto} object containing the mapped data.
     */
    public static AdminDto mapToAdminDto(Admins admin) {
        return new AdminDto(
                admin.getId(),
                admin.getFirst_name(),
                admin.getLast_name(),
                admin.getEmail(),
                admin.password() // Or use admin.getPassword() if you decide to keep the getter method
        );
    }

    /**
     * Maps an {@link AdminDto} object to an {@link Admins} object.
     *
     * @param adminDto The {@link AdminDto} object to be mapped.
     * @return An {@link Admins} object containing the mapped data.
     */
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
