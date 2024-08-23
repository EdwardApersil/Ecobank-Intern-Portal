package com.ecobank.intern_portal.repository;

import com.ecobank.intern_portal.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository extends JpaRepository<Admins, Long> {
//    boolean existsByPassword(String password);

}
