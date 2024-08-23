package com.ecobank.intern_portal.repository;

import com.ecobank.intern_portal.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRespository extends JpaRepository<Complaint, Long> {

}
