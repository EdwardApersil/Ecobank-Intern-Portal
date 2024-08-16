package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.AdminDto;
import com.ecobank.intern_portal.mapper.AdminMapper;
import com.ecobank.intern_portal.model.Admins;
import com.ecobank.intern_portal.repository.AdminRespository;
import com.ecobank.intern_portal.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminImplement implements AdminService {
    // Implementing AdminService methods

    private AdminRespository adminRespository;

    @Override
    public AdminDto createAdmin(AdminDto adminDto){
        Admins Admins = AdminMapper.mapToAdmin(adminDto);
        com.ecobank.intern_portal.model.Admins savedAdmin = adminRespository.save(Admins);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

    // Get the admin by its id
    @Override
    public AdminDto getAdminById(Long id) {
        Admins Admins = adminRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin with id: " + id + " not found"));
        return AdminMapper.mapToAdminDto(Admins);
    }

    // Get all admin list
    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admins> Admins = adminRespository.findAll();
        return Admins.stream().map(AdminMapper::mapToAdminDto).collect(Collectors.toList());
    }

    // Update the admin by its id
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

    // Delete the admin by its id
    @Override
    public void deleteAdmin(Long id) {
        adminRespository.deleteById(id);
    }



}
