package com.ecobank.intern_portal.repository;

import com.ecobank.intern_portal.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRespository extends JpaRepository<Intern, Long> {

}
