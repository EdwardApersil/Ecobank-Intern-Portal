package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.AdminDto;
import com.ecobank.intern_portal.mapper.AdminMapper;
import com.ecobank.intern_portal.model.Admins;
import com.ecobank.intern_portal.repository.AdminRespository;
import com.ecobank.intern_portal.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the AdminService interface and provides methods for managing admin operations.
 *
 * @author Edward Apersil
 * @version 1.0
 * @since 2023-01-01
 */
@Service
@AllArgsConstructor
public class AdminImplement implements AdminService {
    // Implementing AdminService methods

    /**
     * The admin repository for database operations.
     */
    private AdminRespository adminRespository;

    /**
     * Creates a new admin in the system.
     *
     * @param adminDto The admin data transfer object containing the admin details.
     * @return The created admin data transfer object.
     * @throws IllegalArgumentException If the password already exists in the system.
     */
    @Override
    public AdminDto createAdmin(AdminDto adminDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Check if a hashed version of this password already exists
        List<Admins> allAdmins = adminRespository.findAll();
        for (Admins admin : allAdmins) {
            if (passwordEncoder.matches(adminDto.getPassword(), admin.getPassword())) {
                throw new IllegalArgumentException("The password already exists. Please choose a different password.");
            }
        }
        Admins Admins = AdminMapper.mapToAdmin(adminDto);
        com.ecobank.intern_portal.model.Admins savedAdmin = adminRespository.save(Admins);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

    /**
     * Retrieves an admin by its id.
     *
     * @param id The id of the admin to retrieve.
     * @return The admin data transfer object.
     * @throws RuntimeException If the admin with the given id is not found.
     */
    @Override
    public AdminDto getAdminById(Long id) {
        Admins Admins = adminRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin with id: " + id + " not found"));
        return AdminMapper.mapToAdminDto(Admins);
    }

    /**
     * Retrieves all admin data transfer objects.
     *
     * @return A list of admin data transfer objects.
     */
    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admins> Admins = adminRespository.findAll();
        return Admins.stream().map(AdminMapper::mapToAdminDto).collect(Collectors.toList());
    }

    /**
     * Updates an admin by its id.
     *
     * @param id The id of the admin to update.
     * @param updatedAdminDto The updated admin data transfer object.
     * @return The updated admin data transfer object.
     * @throws RuntimeException If the admin with the given id is not found.
     */
    @Override
    public AdminDto updateAdmin(Long id, AdminDto updatedAdminDto) {
        Admins Admins = adminRespository.findById(id)
               .orElseThrow(() -> new RuntimeException("Admin with id: " + id + " not found"));
        Admins.setFirst_name(updatedAdminDto.getFirst_name());
        Admins.setLast_name(updatedAdminDto.getLast_name());
        Admins.setEmail(updatedAdminDto.getEmail());
        Admins.setPassword(updatedAdminDto.getPassword());
//        admin.setRole(updatedAdminDto.getRole());
        com.ecobank.intern_portal.model.Admins updatedAdmin = adminRespository.save(Admins);
        return AdminMapper.mapToAdminDto(updatedAdmin);
    }

    /**
     * Deletes an admin by its id.
     *
     * @param id The id of the admin to delete.
     */
    @Override
    public void deleteAdmin(Long id) {
        adminRespository.deleteById(id);
    }
}
